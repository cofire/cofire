package com.cofire.console.common;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description:全局异常捕获
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 权限不足报错拦截
     */
    @ExceptionHandler(UnknownAccountException.class)
    public String unknownAccountException() {
        return "{\"success\" : false, \"msg\" : \"账号或者密码错误，请重新登录!\"}";
    }

    /**
     * 权限不足报错拦截
     */
    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExceptionHandler() {
        return "{\"success\" : false, \"msg\" : \"您没有这个功能的权限，请联系管理员!\"}";
    }
}
