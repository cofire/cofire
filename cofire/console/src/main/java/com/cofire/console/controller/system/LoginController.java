package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.console.service.sytem.ILoginService;
import com.cofire.dao.model.system.SysUser;

@RestController
public class LoginController extends SystemBaseController {
    @Autowired
    private ILoginService loginService;

    @RequestMapping("/login")
    public Result login(SysUser user) {
        return loginService.authLogin(user);
    }

    @RequestMapping("/loginOut")
    public Result loginOut() {
        return loginService.logout();
    }
}
