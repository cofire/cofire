package com.cofire.console.controller.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.common.utils.constant.CodeEnum;

@RestController
@RequestMapping("/error")
public class ErrorController {

    /**
     * 
     * @Title: sessionTimeOut
     * @Description:session超时或不存在处理
     * @return
     * @return Result 返回类型
     */
    @RequestMapping("/sessionTimeOut")
    public Result sessionTimeOut() {
        Result result = new Result(false, CodeEnum.E_402);
        return result;
    }

    /**
     * 
     * @Title: unauth
     * @Description:权限验证失败
     * @return
     * @return String 返回类型
     */
    @RequestMapping("/unauth")
    public Result unauth() {
        Result result = new Result(false, CodeEnum.E_401);
        return result;
    }

}
