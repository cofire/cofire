package com.cofire.basic.crawel.spider;

import com.cofire.basic.crawel.core.LoadTemplate;
import com.cofire.basic.crawel.core.SpiderEngine;
import com.cofire.basic.crawel.template.SpiderTemplate;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class MzituSpider {

    public static final String TEMPLATE_PATH = "src/main/java/com/cofire/basic/crawel/templates/mzitu.json";

    public static void main(String[] args) {
        SpiderTemplate template = LoadTemplate.load(TEMPLATE_PATH);
        System.out.println(template);
        SpiderEngine spider = new SpiderEngine(template);
        spider.start();
    }

}
