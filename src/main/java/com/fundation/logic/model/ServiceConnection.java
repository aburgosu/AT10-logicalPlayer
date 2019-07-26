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

/**
 * Implements the connection to the service to convert module.
 *
 * @author Andrés Burgos
 * @version 1.0
 */
public class ServiceConnection {
    CloseableHttpClient httpClient;
    HttpPost httpPost;

    public ServiceConnection(String uri) {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(uri);
    }

    /**
     * Connect to the service to convert.
     * @param criteria - Criteria generated from data obtained since UI.
     * @return URL to download the file resultant of conversion process.
     */
    public String convert(ConvertCriteria criteria) throws Exception {
        String res = "";
        FileBody fileBody = new FileBody(new File(criteria.getSourcePath()));

        StringBody stringInput = new StringBody("{\"typeConversion\":\""
                + "videoCONVERT" + "\",\"checksum\":\"" + Checksum.getChecksum(criteria.getSourcePath(), "MD5")
                + "\",\"destPath\":\"" + criteria.getDestinationPath().replace("\\", "\\\\") + "\""
                + "}", ContentType.TEXT_PLAIN);



        StringBody stringConfig = new StringBody(JsonConverter.convertCriteriaToJson(criteria), ContentType.TEXT_PLAIN);
        StringBody stringOutput = new StringBody("{\"name\":\"" + criteria.getNewName() + "\",\"ext\":\"." + criteria.getNewFormat() + "\"}", ContentType.TEXT_PLAIN);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("asset", fileBody)
                .addPart("input", stringInput)
                .addPart("config", stringConfig)
                .addPart("output", stringOutput)
                .build();
        httpPost.setEntity(reqEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        try {
            HttpEntity resEntity = response.getEntity();
            if (response.getStatusLine().toString().contains("200")) {
                //Add to logger
                res = "Successful conversion";
                // TO DO res = response.
            }
            EntityUtils.consume(resEntity);
        } finally {
            response.close();
        }
        return res;
    }
}
