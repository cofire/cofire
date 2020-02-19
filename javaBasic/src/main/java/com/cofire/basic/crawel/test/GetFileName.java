package com.cofire.basic.crawel.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ly
 * @Description
 * @date 2020/02/18
 **/
public class GetFileName {
    public static void main(String[] args) {
        String url = "http://XXX.abc.org/XXX/XXX/124?path=filename.JPG";
        String suffixes = "(?i)avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|txt|html|htm|java|doc";
        Pattern pat = Pattern.compile("[\\w]+[\\.](" + suffixes + ")");//正则判断
        Matcher mc = pat.matcher(url);
        while (mc.find()) {
            String substring = mc.group();//截取文件名后缀名
            System.out.println(substring);
        }
    }
}
