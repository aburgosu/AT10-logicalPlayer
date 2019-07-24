package com.fundation.logic.model;

import com.fundation.logic.common.JsonConverter;
import com.fundation.logic.model.convertCriteria.ConvertCriteria;
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

public class ServiceConnection {
    CloseableHttpClient httpClient;
    HttpPost httpPost;

    public ServiceConnection(String uri) {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(uri);
    }

    public String convert(ConvertCriteria criteria) throws Exception {
        String res="";
        FileBody fileBody = new FileBody(new File(criteria.getSourcePath()));
        StringBody stringInput = new StringBody(Checksum.getChecksum(criteria.getSourcePath(),"MD5"), ContentType.TEXT_PLAIN);
        StringBody stringConfig = new StringBody(JsonConverter.convertCriteriaToJson(criteria), ContentType.TEXT_PLAIN);
        StringBody stringOutput = new StringBody(criteria.getDestinationPath(), ContentType.TEXT_PLAIN);

        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("asset", fileBody)
                .addPart("input", stringInput)
                .addPart("config",stringConfig)
                .addPart("output",stringOutput)
                .build();
        httpPost.setEntity(reqEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        try {
            HttpEntity resEntity = response.getEntity();
            if (response.getStatusLine().toString().contains("200")) {
                //Add to logger
                System.out.println("Successful conversion");
                //res = response.
            }
            EntityUtils.consume(resEntity);
        } finally {
            response.close();
        }

        return res;
    }
}
