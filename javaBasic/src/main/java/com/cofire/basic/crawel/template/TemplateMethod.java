package com.cofire.basic.crawel.template;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class TemplateMethod {
    //    方法名称
    private String name;
    //    方法参数 默认一个且为string
    private String param;
    //    允许方法链
    private TemplateMethod templateMethod;

    public TemplateMethod(String name, String param) {
        this.name = name;
        this.param = param;
    }

    public TemplateMethod(String name, String param, TemplateMethod templateMethod) {
        this.name = name;
        this.param = param;
        this.templateMethod = templateMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public TemplateMethod getTemplateMethod() {
        return templateMethod;
    }

    public void setTemplateMethod(TemplateMethod templateMethod) {
        this.templateMethod = templateMethod;
    }
}
