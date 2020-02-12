package com.cofire.basic.crawel.template;

import java.util.List;

/**
 * @author ly
 * @Description
 * @date 2020/02/11
 **/
public class SpiderTemplate {
    //    模板标题
    private String title;
    //    起始连接
    private String baseUrl;
    //    备注说明
    private String remark;
    //    对应数据库表名
    private String table;
    //分页链接规则
    private PageHref pageHref;
    //开始位置选择器
    private String parentCssPath;
    //      字段列表
    private List<TemplateField> templateFieldList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public PageHref getPageHref() {
        return pageHref;
    }

    public void setPageHref(PageHref pageHref) {
        this.pageHref = pageHref;
    }

    public String getParentCssPath() {
        return parentCssPath;
    }

    public void setParentCssPath(String parentCssPath) {
        this.parentCssPath = parentCssPath;
    }

    public List<TemplateField> getTemplateFieldList() {
        return templateFieldList;
    }

    public void setTemplateFieldList(List<TemplateField> templateFieldList) {
        this.templateFieldList = templateFieldList;
    }
}
