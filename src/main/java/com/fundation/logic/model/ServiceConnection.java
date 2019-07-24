package com.fundation.logic.model;

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
import java.io.IOException;

public class ServiceConnection {
    CloseableHttpClient httpClient;
    HttpPost httpPost;

    public ServiceConnection(String uri) {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(uri);
    }



    public String convert(String asset, String input, String config, String output) throws IOException {
        String res="";
        FileBody fileBody = new FileBody(new File(asset));
        StringBody stringInput = new StringBody(input, ContentType.TEXT_PLAIN);
        StringBody stringConfig = new StringBody(config, ContentType.TEXT_PLAIN);
        StringBody stringOutput = new StringBody(output, ContentType.TEXT_PLAIN);

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
