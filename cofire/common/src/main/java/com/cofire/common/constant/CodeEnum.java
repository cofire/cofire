package com.cofire.common.constant;

/**
 * @author ly
 * @version V1.0
 * @ClassName: CodeEnum
 * @Description:返回码
 * @date 2019年12月4日
 */
public enum CodeEnum {

    // 请求成功
    E_200("200", "success"),
    // 参数或者校验不通过
    E_400("400", "400 Bad Request"),
    // 权限验证失败
    E_401("401", "401 Unauthorized"),
    // 登录超时
    E_402("402", "402 sessionTimeOut"),
    // 请求未找到
    E_404("404", "404 Not Found"),
    // 服务错误
    E_500("500", "Intertnal Server Error"),
    // 查询成功
    E_600("600", "Query success"),
    // 查询失败
    E_601("601", "Query fail"),
    // 保存成功
    E_700("700", "Save success"),
    // 保存失败
    E_701("701", "Save fail"),
    // 删除成功
    E_800("800", "Delete success"),
    // 删除失败
    E_801("801", "Delete fail"),
    // 登录成功
    E_900("900", "Login success"),
    // 登录失败
    E_901("901", "Login fail"),
    // 登出成功
    E_902("902", "LoginOut success"),
    // 登出失败
    E_903("903", "LoginOut fail");
    private String code;

    private String message;

    CodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
