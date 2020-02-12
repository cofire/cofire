package com.cofire.basic.crawel.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class ParseHtmlReflex {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("http://www.yiibai.com").get();
            Method select = document.getClass().getSuperclass().getDeclaredMethod("select", String.class);
            Elements xoxoList = (Elements) select.invoke(document, ".xoxo li");
            for (Element xoxo : xoxoList) {
                System.out.println(xoxo.getElementsByTag("a").attr("href"));
                System.out.println(xoxo.getElementsByTag("a").text());
                System.out.println(xoxo.ownText());
            }
        } catch (
                IOException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
