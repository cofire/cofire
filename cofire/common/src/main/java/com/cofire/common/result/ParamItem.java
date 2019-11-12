package com.cofire.common.result;

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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        if (length > 100) {
            length = 100;
        }
        this.length = length;
    }
}
