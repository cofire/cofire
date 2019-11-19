package com.cofire.common.result;

import org.apache.commons.lang.StringUtils;

import com.cofire.common.constant.Constants;

/**
 * 
 * @ClassName: paramItem
 * @Description:接受前台传过来的数据中公共请求参数
 * @date 2019年5月13日
 *
 * @param <T>
 */
public class ParamItem {
    // 当前页面
    private Integer page;
    // 页面大小
    private Integer length;
    // 操作类型
    private String operation;
    // 操作来源
    private String sourceType;
    // 排序字段
    private String sort;
    // 排序类型
    private String order;

    public ParamItem() {
        this.page = 1;
        this.length = 10;
    }

    public ParamItem(Integer page, Integer length) {
        this.page = page;
        if (length > 100) {
            length = 100;
        }
        this.length = length;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            page = 1;
        }
        this.page = page;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        if (length == null) {
            length = 10;
        }
        if (length > 100) {
            length = 100;
        }
        this.length = length;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        if (StringUtils.isEmpty(order)) {
            this.order = "";
            return;
        }
        switch (StringUtils.upperCase(order)) {
            case Constants.SORT_ASC:
                this.order = Constants.SORT_ASC;
                break;
            case Constants.SORT_DESC:
                this.order = Constants.SORT_DESC;
                break;
            case Constants.SORT_ASCENDING:
                this.order = Constants.SORT_ASC;
                break;
            case Constants.SORT_DESCENDING:
                this.order = Constants.SORT_DESC;
                break;
            default:
                this.order = "";
                break;
        }
    }

    /**
     * 
     * @Title: getOrderByClause
     * @author ly
     * @Description:组合排序字段
     * @param @return 参数
     * @return String 返回类型
     */
    public String getOrderByClause() {
        if (StringUtils.isBlank(this.sort)) {
            return null;
        }
        if (StringUtils.isBlank(this.order)) {
            return this.sort;
        }
        return this.sort + " " + this.order;
    }
}
