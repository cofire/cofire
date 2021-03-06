package com.cofire.common.constant;

/**
 * @author: hxy
 * @description: 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 * @date: 2017/10/24 10:15
 */
public class Constants {
    public static final String MYSQL = "mysql";

    /**
     * 查询
     */
    public static final String OPERATION_QUERY = "query";
    /**
     * 新增
     */
    public static final String OPERATION_ADD = "add";
    /**
     * 修改
     */
    public static final String OPERATION_UPDATE = "update";
    /**
     * 删除
     */
    public static final String OPERATION_DELETE = "delete";
    /**
     * 导出
     */
    public static final String OPERATION_EXPORT = "export";
    /**
     * 上传
     */
    public static final String OPERATION_UPLOAD = "upload";

    /**
     * 保存
     **/
    public static final String OPERATION_SAVE = "save";

    /**
     * 菜单根节点
     */
    public static final String MENU_ROOT = "Root";

    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";
    /**
     * 登录登出
     */
    public static final String AUDIT_TYPE_LOGIN = "0";
    public static final String AUDIT_TYPE_LOGIN_OUT = "1";
    /**
     * 登录登出来源
     */
    public static final String SOURCE_TYPE_PC = "0";
    public static final String SOURCE_TYPE_IPAD = "1";
    public static final String SOURCE_TYPE_XINIU = "2";

    /**
     * 数据库查询排序枚举
     */
    /**
     * 升序
     */
    public static final String SORT_ASC = "ASC";
    /**
     * 降序
     */
    public static final String SORT_DESC = "DESC";
    /**
     * 升序
     */
    public static final String SORT_ASCENDING = "ASCENDING";
    /**
     * 降序
     */
    public static final String SORT_DESCENDING = "DESCENDING";

    // 判断请求参数类型是否为JSON字符串方式
    public static final String IS_JSON_PARAM = "IS_JSON_PARAM";

    // content-type
    public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
    public static final String CONTENT_TYPE_JSON_N = "application/json";
    public static final String CONTENT_TYPE_TEXT_JSON = "text/json;charset=utf-8";
    public static final String CONTENT_TYPE_TEXT_JSON_N = "text/json";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String CONTENT_TYPE_FORM_N = "application/x-www-form-urlencoded";

    public static final String CHARSET_UTF_8 = "UTF-8";

    public static final String JSON_PARAM = "JSON_PARAM";
}
