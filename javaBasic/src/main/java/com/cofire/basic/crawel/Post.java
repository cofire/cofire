package com.cofire.basic.crawel;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 * @Description
 * @date 2020/01/14
 **/
public class Post {
    public static void main(String[] args) {
        try {
            Connection conn = Jsoup.connect("http://www.cool-srv.com:8089/console/login");
            conn.data("userId","admin");
            conn.data("passwd","637e2e97551576da3389137841e7d7d6");
            conn.data("filler1","console");
            Document doc = conn.ignoreContentType(true).post();
            System.out.println(doc);
            Connection connection = Jsoup.connect("http://www.cool-srv.com:8089/console/getUserDetail");
            Document document = connection.ignoreContentType(true).post();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
