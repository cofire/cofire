package com.cofire.basic.crawel.core;

import org.apache.commons.lang3.StringUtils;
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
    private static final String BATH_PATH = "D:\\data\\spider";

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
     * 获取URL中的文件名
     **/
    public static String getFileName(String url, Connection.Response response) {
        String fileName = getFileName(url);
        if (response == null) {
            return fileName;
        }
        if (fileName.indexOf(".") < 0) {
            return fileName + getSuffixe(response.contentType());
        }
        return fileName;
    }


    /**
     * 图片下载
     **/
    public static String downLoad(String url) {
        return downLoad(url, BATH_PATH);
    }

    /**
     * 图片下载
     **/
    public static String downLoad(String url, String bathPath) {
        System.out.println("正在下载图片：" + url);
        String fileName = "";
        bathPath = deelBathPath(bathPath);
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36").timeout(5000).execute();
            fileName = getFileName(url, response);
            byte[] img = response.bodyAsBytes();
            FileCopyUtils.copy(img, new FileOutputStream(bathPath + "/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("下载完成");
        return fileName;
    }


    /**
     * 图片下载
     **/
    public static String downLoad(String url, String bathPath, String childrenPath) {
        String fileName = "";
        bathPath = deelBathPath(bathPath);
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36").timeout(5000).execute();
            fileName = getFileName(url, response);
            byte[] img = response.bodyAsBytes();
            FileCopyUtils.copy(img, new FileOutputStream(bathPath + "/" + childrenPath + "/" + fileName));
            return childrenPath + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 处理根目录不存在的情况
     **/
    public static String deelBathPath(String basePath) {
        if (StringUtils.isEmpty(basePath)) {
            return BATH_PATH;
        }
        return basePath;
    }

    public static String getSuffixe(String contentType) {
        if (StringUtils.isEmpty(contentType)) {
            return "";
        }
        return ContentTypeMap.getSuffix(contentType);
    }

    public static void main(String[] args) {
        downLoad("https://p1.pstatp.com/large/pgc-image/b63aeefa6b3d4cda8a75a99a1b369222");

    }
}
