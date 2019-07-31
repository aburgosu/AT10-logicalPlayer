/**
 * Copyright (c) 2019 Jalasoft.
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.fundation.logic.model;

import com.fundation.logic.common.JsonConverter;
import com.fundation.logic.model.convertCriteriaBuilderPattern.ConvertCriteria;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implements the connection to the service to convert module.
 *
 * @author Andrés Burgos
 * @version 1.0
 */
public class ServiceConnection {
    private CloseableHttpClient httpClient;
    private HttpPost httpPost;
    private int status;

    public static final int IN_PROCCES=0;
    public static final int SUCCESS=1;
    public static final int ERROR=2;

    public ServiceConnection() {
        httpClient = HttpClients.createDefault();
        String uri = readConfigurationEndpoint();
        httpPost = new HttpPost(uri);
    }

    private String readConfigurationEndpoint() {
        InputStream inputProperties;
        Properties properties = new Properties();
        try {
            inputProperties = new FileInputStream("config.properties");
            properties.load(inputProperties);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("server.endpoint");
    }

    /**
     * Connect to the service to convert.
     * @param criteria - Criteria generated from data obtained since UI.
     * @return URL to download the file resultant of conversion process.
     */
    public String convert(ConvertCriteria criteria) {
        String res = "";
        FileBody fileBody = new FileBody(new File(criteria.getSourcePath()));
        StringBody stringInput = null;
        try {
            stringInput = new StringBody("{\"typeConversion\":\""
                    + criteria.getConvertType() + "\",\"checksum\":\"" + Checksum.getChecksum(criteria.getSourcePath(), "MD5")
                    + "\"}", ContentType.TEXT_PLAIN);
        } catch (Exception e) {
            status = this.ERROR;
        }
        StringBody stringConfig = new StringBody(JsonConverter.convertCriteriaToJson(criteria), ContentType.TEXT_PLAIN);
        StringBody stringOutput = new StringBody("{\"name\":\"" + criteria.getNewName() + "\",\"ext\":\"." + criteria.getNewFormat() + "\","
                    + "\"destPath\":\"" + criteria.getDestPath().replace("\\", "\\\\") + "\"" + "}" , ContentType.TEXT_PLAIN);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("asset", fileBody)
                .addPart("input", stringInput)
                .addPart("config", stringConfig)
                .addPart("output", stringOutput)
                .build();
        httpPost.setEntity(reqEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            status = this.IN_PROCCES;
        } catch (IOException e) {
            status = this.ERROR;
        }
        try {
            if (response.getStatusLine().toString().contains("200")) {
                res = "Successful conversion";
                status = this.SUCCESS;
            }
            if (!response.getStatusLine().toString().contains("200")) {
                res = "Conversion error";
                status = this.ERROR;
            }
            HttpEntity resEntity = response.getEntity();
            try {
                EntityUtils.consume(resEntity);
            } catch (IOException e) {
                status = this.ERROR;
            }
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                status = this.ERROR;
            }
        }
        return res;
    }

    /**
     * Allows to get status to convert process.
     */
    public int getStatus() {
        return status;
    }
}
