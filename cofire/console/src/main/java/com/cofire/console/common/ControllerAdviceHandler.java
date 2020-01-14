package com.cofire.console.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.Result;

/**
 * @author ly
 * @version V1.0
 * @ClassName: GlobalExceptionHandler
 * @Description:全局异常捕获
 * @date 2019年12月4日
 */
@ControllerAdvice
@ResponseBody
public class ControllerAdviceHandler {

    @ExceptionHandler(Exception.class)
    public Result exception() {
        Result result = new Result();
        result.setCode(CodeEnum.E_500.getCode());
        result.setMessage(CodeEnum.E_500.getMessage());
        return result;
    }
}
