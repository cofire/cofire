package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.console.service.sytem.ILoginService;

/**
 * @author ly
 * @version V1.0
 * @ClassName: LoginController
 * @Description:登录登出
 * @date 2019年12月4日
 */
@RestController
@RequestMapping("/console")
public class LoginController extends SystemBaseController {
    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public Result login(String userId, String passWord, String source, String operation) {
        return loginService.authLogin(userId, passWord, source, operation);
    }

    @RequestMapping("/loginOut")
    public Result loginOut(String source, String operation) {
        return loginService.logout(source, operation);
    }
}
