package com.cofire.basic.crawel.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class Mzitu {
    public static void main(String[] args) throws IOException {
        try {
            Document document = Jsoup.connect("https://www.mzitu.com/").get();
            Elements xoxoList = document.select("#pins li");

//            System.out.println(xoxoList);
            for (Element xoxo : xoxoList) {
                System.out.println(xoxo.select("a").attr("href"));
                System.out.println(xoxo.select("span a").text());
                System.out.println(xoxo.getElementsByTag("img").attr("data-original"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
