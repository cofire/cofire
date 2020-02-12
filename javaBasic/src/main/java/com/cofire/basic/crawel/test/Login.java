package com.cofire.basic.crawel.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/01/14
 **/
public class Login {
    public static void main(String[] args) {
        try {
            Connection conn = Jsoup.connect("http://www.cool-srv.com:8089/console/login");
            conn.data("userId", "admin");
            conn.data("passwd", "637e2e97551576da3389137841e7d7d6");
            conn.data("filler1", "console");
            Connection.Response res = conn.ignoreContentType(true).method(Connection.Method.POST).execute();
            System.out.println(res.body());
            System.out.println(res.cookie("JSESSIONID"));
            Connection connection = Jsoup.connect("http://www.cool-srv.com:8089/console/getUserDetail");
            Document document = connection.ignoreContentType(true).cookie("JSESSIONID", res.cookie("JSESSIONID")).post();
            System.out.println(document.body().text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
