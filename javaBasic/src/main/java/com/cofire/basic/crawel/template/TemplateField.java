package com.cofire.basic.crawel.template;


/**
 * @author ly
 * @Description
 * @date 2020/02/11
 **/
public class TemplateField {
    //    数据库映射字段
    private String templateField;
    //    字段获取方法
    private TemplateMethod templateMethod;

    public String getTemplateField() {
        return templateField;
    }

    public void setTemplateField(String templateField) {
        this.templateField = templateField;
    }

    public TemplateMethod getTemplateMethod() {
        return templateMethod;
    }

    public void setTemplateMethod(TemplateMethod templateMethod) {
        this.templateMethod = templateMethod;
    }
}
