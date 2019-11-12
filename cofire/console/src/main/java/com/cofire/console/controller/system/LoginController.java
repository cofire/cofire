package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.console.service.sytem.ILoginService;

@RestController
@RequestMapping("/console")
public class LoginController extends SystemBaseController {
    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public Result login(String userId, String passWord, String sourceType, String operation) {
        return loginService.authLogin(userId, passWord, sourceType, operation);
    }

    @RequestMapping("/loginOut")
    public Result loginOut(String sourceType, String operation) {
        return loginService.logout(sourceType, operation);
    }
}
