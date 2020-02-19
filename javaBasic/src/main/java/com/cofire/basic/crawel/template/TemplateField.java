package com.cofire.basic.crawel.template;


/**
 * @author ly
 * @Description
 * @date 2020/02/11
 **/
public class TemplateField {
    //    数据库映射字段
    private String templateField;
    //    字段类型
    private String fieldType;
    //    字段获取方法
    private TemplateMethod templateMethod;

    public String getTemplateField() {
        return templateField;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
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
