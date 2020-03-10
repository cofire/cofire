package com.cofire.console.common;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

    private final static Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        if (e instanceof NullPointerException) {
            logger.error("空指针异常：{}", e.getMessage());
            return new Result(false, CodeEnum.E_500.getCode(), "服务端出现数据为空异常");
        } else if (e instanceof DuplicateKeyException) {
            logger.error("主键冲突异常：{}", e.getMessage());
            return new Result(false, CodeEnum.E_500.getCode(), "数据库主键冲突异常");
        }
        logger.error("系统异常:{}", e.getMessage());
        return new Result(false, CodeEnum.E_500.getCode(), "系统异常");
    }
}
