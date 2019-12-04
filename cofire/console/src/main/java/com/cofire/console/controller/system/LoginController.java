package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.ILoginService;

/**
 * 
 * @ClassName: LoginController
 * @Description:登录登出
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@RestController
@RequestMapping("/console")
public class LoginController extends SystemBaseController {
    @Autowired
    private ILoginService loginService;

    @BussinessLog("登录")
    @RequestMapping("/login")
    public Result login(String userId, String passWord, String source, String operation) {
        return loginService.authLogin(userId, passWord, source, operation);
    }

    @BussinessLog("登出")
    @RequestMapping("/loginOut")
    public Result loginOut(String source, String operation) {
        return loginService.logout(source, operation);
    }
}
