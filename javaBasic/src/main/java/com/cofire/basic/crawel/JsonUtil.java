package com.cofire.basic.crawel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * @author ly
 * @Description
 * @date 2020/02/11
 **/
public class JsonUtil {
    private static final Logger logger = LogManager.getLogger(JsonUtil.class);

    /**
     * 读取json文件
     *
     * @param jsonFile json文件名
     * @return 返回json字符串
     */
    public static String readJsonFile(File jsonFile) {
        String jsonStr = "";
        logger.info("————开始读取" + jsonFile.getPath() + "文件————");
        try {
            //File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            logger.info("————读取" + jsonFile.getPath() + "文件结束!————");
            return jsonStr;
        } catch (Exception e) {
            logger.info("————读取" + jsonFile.getPath() + "文件出现异常，读取失败!————");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        File file = new File("src/main/java/com/cofire/basic/crawel/templates/boc2.json");
//        String jsonStr = readJsonFile(file);
//        System.out.println(jsonStr);
    }
}
