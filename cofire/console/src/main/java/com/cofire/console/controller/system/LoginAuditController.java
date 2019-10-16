package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.ILoginAuditService;
import com.cofire.dao.model.system.SysLoginAudit;

@RestController
public class LoginAuditController extends SystemBaseController {

    @Autowired
    private ILoginAuditService loginAuditService;

    @BussinessLog("查询登录登出日志")
    @RequestMapping(value = "/loginAudit/query", method = { RequestMethod.POST })
    public Result queryLoginAudit(ParamItem loginAuditItem, SysLoginAudit loginAudit) {
        return loginAuditService.query(loginAuditItem, loginAudit);
    }

}