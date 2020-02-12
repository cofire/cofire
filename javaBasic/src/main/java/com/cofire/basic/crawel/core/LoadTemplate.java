package com.cofire.basic.crawel.core;

import com.alibaba.fastjson.JSONObject;
import com.cofire.basic.crawel.template.SpiderTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class LoadTemplate {
    private static final Logger logger = LogManager.getLogger(LoadTemplate.class);

    public static SpiderTemplate load(String templatePath) {
        if (StringUtils.isEmpty(templatePath)) {
            return null;
        }
        File file = new File(templatePath);
        logger.info("————开始读取" + file.getPath() + "文件————");
        try {
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            String templateStr = sb.toString();
            logger.info("————读取" + file.getPath() + "文件结束!————");
            return JSONObject.parseObject(templateStr, SpiderTemplate.class);
        } catch (Exception e) {
            logger.info("————读取" + file.getPath() + "文件出现异常，读取失败!————");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(load("src/main/java/com/cofire/basic/crawel/templates/mzitu.json"));
    }
}
