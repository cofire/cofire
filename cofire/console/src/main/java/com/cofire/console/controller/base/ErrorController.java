package com.cofire.console.controller.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.Result;

/**
 * @author ly
 * @version V1.0
 * @ClassName: ErrorController
 * @Description:错误信息返回
 * @date 2019年12月4日
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    /**
     * @return Result 返回类型
     * @Title: sessionTimeOut
     * @Description:session超时或不存在处理
     */
    @RequestMapping("/sessionTimeOut")
    public Result sessionTimeOut() {
        Result result = new Result(false, CodeEnum.E_402);
        return result;
    }

    /**
     * @return String 返回类型
     * @Title: unauth
     * @Description:权限验证失败
     */
    @RequestMapping("/unauth")
    public Result unauth() {
        Result result = new Result(false, CodeEnum.E_401);
        return result;
    }

    /**
     * @param @return 参数
     * @return Result 返回类型
     * @Title: exportError
     * @author ly
     * @Description:文件导出异常
     */
    @RequestMapping("/exportError")
    public Result exportError() {
        Result result = new Result(false, CodeEnum.E_500);
        return result;
    }

}
