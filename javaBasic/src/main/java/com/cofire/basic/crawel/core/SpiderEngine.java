package com.cofire.basic.crawel.core;

import com.alibaba.fastjson.JSONObject;
import com.cofire.basic.crawel.template.SpiderTemplate;
import com.cofire.basic.crawel.template.TemplateField;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class SpiderEngine {
    private static final Logger log = LoggerFactory.getLogger(SpiderEngine.class);

    private SpiderTemplate spiderTemplate;

    public SpiderEngine(SpiderTemplate spiderTemplate) {
        this.spiderTemplate = spiderTemplate;
    }

    public void start() {
        log.info("开始爬取{}", spiderTemplate.getTitle());
        List<TemplateField> templateFieldList = spiderTemplate.getTemplateFieldList();
        try {
            Document document = Jsoup.connect(spiderTemplate.getStartUrl()).get();
            Elements contentList = document.select(spiderTemplate.getParentCssPath());
            List<HashMap<String, String>> resultMapList = new ArrayList<>();
            HashMap resultMap = new HashMap();
            for (Element content : contentList) {
                HashMap<String, String> map = new HashMap<>();
                for (TemplateField field : spiderTemplate.getTemplateFieldList()) {
                    map.put(field.getTemplateField(), DefaultParser.getElementValue(content,
                            field.getFieldType(), field.getTemplateMethod()));
                }
                resultMapList.add(map);
            }
            resultMap.put("result", resultMapList);
            System.out.println(new JSONObject(resultMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
