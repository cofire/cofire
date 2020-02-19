package com.cofire.basic.crawel.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/01/14
 **/
public class DownLoadImage {
    public static void main(String[] args) throws IOException {
        String imageSrc = "https://p3.pstatp.com/large/pgc-image/873fd02ea8304a8eb7549d1dd13afce0";
        Connection.Response response = Jsoup.connect(imageSrc).ignoreContentType(true).userAgent("Mozilla/5.0 " +
                "(Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).execute();
        byte[] img = response.bodyAsBytes();
        System.out.println(img.length);
        System.out.println(response.contentType());
        FileCopyUtils.copy(img, new FileOutputStream("D:\\data\\test"));


    }
}
