package com.cofire.common.constant;

/**
 * 
 * @ClassName: CodeEnum
 * @Description:返回码分为10位，前两位划分子系统（00代表系统模块公共返回参数，01代表用户管理，依次类推）， 中间两位划分页面（每一个页面一个返回码），
 *                                                               五六位划分功能（00-新增，01-修改，02-删除，03-查询），七到十位自定义返回码（自定义不重复即可)
 * @date 2019年5月13日
 *
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
    E_500("500", "Intertnal Server Error");

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