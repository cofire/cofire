package com.cofire.basic.crawel.core;

/**
 * @author ly
 * @Description 定义爬虫模板中的常量
 * @date 2020/02/19
 **/
public interface SpiderConstants {
    //    字段的类型 默认为文本
    enum FieldTypeEnum implements SpiderConstants {
        TEXT("text", "文本"), FILE("file", "文件");
        private String code;
        private String message;

        FieldTypeEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
