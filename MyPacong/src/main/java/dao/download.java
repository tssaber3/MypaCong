package dao;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import util.JDBC;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class download {
    public static void main(String[] args) throws Exception {
        pictureDao dao = new pictureDao();
        String name = "E子";
        List<String> list =  dao.serach(name);
        CloseableHttpClient httpClient =  HttpClients.createDefault();
        for (int i = 339; i<list.size();i++)
        {
            File file = new File("d:"+ File.separator+"test" +File.separator+"E子"+File.separator+i+".jpg");
            HttpGet httpGet = new HttpGet(list.get(i));
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(entity != null)
            {
                System.out.println("ContentType:" + entity.getContentType().getValue());
                InputStream inputStream = entity.getContent();
                FileUtils.copyInputStreamToFile(inputStream,file);
            }
        }
    }
}
