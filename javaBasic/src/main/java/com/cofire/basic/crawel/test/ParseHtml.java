package com.cofire.basic.crawel.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/01/14
 **/
public class ParseHtml {
    public static void main(String[] args) throws IOException {
        try {
            Document document = Jsoup.connect("http://www.yiibai.com").get();
//            System.out.println(document.select(".xoxo li"));
            Elements xoxoList = document.select(".xoxo li");
            for (Element xoxo : xoxoList) {
                System.out.println(xoxo.getElementsByTag("a").attr("href"));
                System.out.println(xoxo.getElementsByTag("a").text());
                System.out.println(xoxo.ownText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Connection conn = Jsoup.connect("https://apply.mcard.boc.cn/apply/pc/product/familyHappy/family?rp=200&page=1");
//        Connection.Response res = conn.ignoreContentType(true).method(Connection.Method.GET).postDataCharset("utf-8").execute();
//        System.out.println(res.body());
    }
}
