package com.cofire.common.constant;

/**
 * @author: hxy
 * @description: 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 * @date: 2017/10/24 10:15
 */
public class Constants {
    public static final String MYSQL = "mysql";

    public static final String FLAG_ADD = "add";
    public static final String FLAG_UPDATE = "update";

    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";
    // 登录登出
    public static final String AUDIT_TYPE_LOGIN = "0";
    public static final String AUDIT_TYPE_LOGIN_OUT = "1";
    // 登录登出来源
    public static final String SOURCE_TYPE_PC = "0";
    public static final String SOURCE_TYPE_IPAD = "1";
    public static final String SOURCE_TYPE_XINIU = "2";
}
