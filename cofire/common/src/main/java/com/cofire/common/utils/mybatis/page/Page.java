package com.cofire.common.utils.mybatis.page;

import java.io.Serializable;

/**
 * mybatis 扩展mysql 分页插件的Page类标识
 *
 * @author ly
 */
public class Page implements Serializable {

    /**
     * 默认的序列化版本 id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * 当前页码.
     */
    private Integer page = 0;

    /**
     * 每页显示记录数.
     */
    private Integer length = 10;

    /**
     * 分页查询开始记录位置.
     */
    private int begin;
    /**
     * 分页查看下结束位置.
     */
    private int end;

    public Page() {
    }

    /**
     * 构造函数.前台第一页对应后台第0页
     *
     * @param begin
     * @param length
     */
    public Page(Integer page, Integer length) {
        if (null == page || page < 1) {
            this.page = 0;
        } else {
            this.page = page - 1;
        }

        if (null == length || length < 0) {
            this.length = 10;
        } else {
            this.length = length;
        }

        this.begin = this.page * this.length;
        this.end = this.begin + this.length;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("begin=").append(begin).append(", end=").append(end).append(", length=").append(length)
                .append(", page=").append(page);
        return builder.toString();
    }
}
