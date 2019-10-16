package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IRoleService;
import com.cofire.dao.model.system.SysRole;

@RestController
public class RoleController extends SystemBaseController {

    @Autowired
    private IRoleService roleService;

    @BussinessLog("查询角色信息")
    @RequestMapping(value = "/role/query", method = { RequestMethod.POST })
    public Result queryRole(ParamItem paramItem, SysRole role) {
        return roleService.query(paramItem, role);
    }

    @BussinessLog("保存角色信息")
    @RequestMapping(value = "/role/save", method = { RequestMethod.POST })
    public Result saveRole(String saveFlag, SysRole role) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return roleService.add(role);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return roleService.upadte(role);
        }
        return result;
    }

    @BussinessLog("删除角色信息")
    @RequestMapping(value = "/role/delete", method = { RequestMethod.POST })
    public Result deleteRole(SysRole role) {
        return roleService.delete(role);
    }

}
