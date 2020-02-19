package com.cofire.basic.crawel.core;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ly
 * @Description
 * @date 2020/02/18
 **/
public class FileDownLoad {

    /**
     * 获取URL中的文件名
     **/
    public static String getFileName(String url) {
        String suffixes = "(?i)avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|txt|html|htm|java|doc";
        Pattern pat = Pattern.compile("[\\w]+[\\.](" + suffixes + ")");//正则判断
        Matcher mc = pat.matcher(url);
        while (mc.find()) {
            String fileName = mc.group();//截取文件名后缀名
            return fileName;
        }
        return UUID.randomUUID().toString();
    }

    /**
     * 图片下载
     **/
    public static String downLoad(String url, String bathPath) {
        String fileName = getFileName(url);
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 " +
                    "(Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).execute();

            byte[] img = response.bodyAsBytes();
            FileCopyUtils.copy(img, new FileOutputStream(bathPath + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


    /**
     * 图片下载
     **/
    public static String downLoad(String url, String bathPath, String childrenPath) {
        String fileName = getFileName(url);
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 " +
                    "(Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).execute();

            byte[] img = response.bodyAsBytes();
            FileCopyUtils.copy(img, new FileOutputStream(bathPath + "/" + childrenPath + "/" + fileName));
            return childrenPath + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
