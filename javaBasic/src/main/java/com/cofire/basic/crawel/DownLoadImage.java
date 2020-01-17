package com.cofire.basic.crawel;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.FileCopyUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/01/14
 **/
public class DownLoadImage {
    public static void main(String[] args) throws IOException {
        String imageSrc = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
        Connection.Response response = Jsoup.connect(imageSrc).ignoreContentType(true).userAgent("Mozilla/5.0 " +
                "(Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).execute();;
        byte[] img = response.bodyAsBytes();
        System.out.println(img.length);
        FileCopyUtils.copy(img,new FileOutputStream("D:\\data\\test.png"));
    }
}
