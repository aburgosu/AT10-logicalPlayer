package com.fundation.logic.poc;

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

public class PostService {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://127.0.0.1/convertVideo");

            FileBody fileBody = new FileBody(new File("C:\\Users\\AndresBurgos\\Desktop\\LaCasaDePapel.mp4"));
            StringBody input = new StringBody("df543654246cd9cfbdc153433ea8c023", ContentType.TEXT_PLAIN);
            StringBody config = new StringBody("avi,libvorbis,128000,2,mpeg4,160000,30,json,True,30,False,60", ContentType.TEXT_PLAIN);
            StringBody output = new StringBody("papel,.avi", ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("asset", fileBody)
                    .addPart("input", input)
                    .addPart("config",config)
                    .addPart("output",output)
                    .build();
            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Successful conversion");
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
