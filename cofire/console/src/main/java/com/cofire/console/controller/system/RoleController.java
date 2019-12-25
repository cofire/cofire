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
import com.cofire.dao.model.system.SysUser;

/**
 * @author ly
 * @version V1.0
 * @ClassName: RoleController
 * @Description:角色
 * @date 2019年12月4日
 */
@RestController
@RequestMapping(value = "/console/role")
public class RoleController extends SystemBaseController {

    @Autowired
    private IRoleService roleService;

    @BussinessLog("查询角色信息")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryRole(ParamItem paramItem, SysRole role) {
        return roleService.query(paramItem, role);
    }

    @BussinessLog("保存角色信息")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Result saveRole(String operation, SysRole role, String permission) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return roleService.add(role, permission);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return roleService.update(role, permission);
        }
        return result;
    }

    @BussinessLog("删除角色信息")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result deleteRole(SysRole role) {
        return roleService.delete(role);
    }

    @BussinessLog("查询用户角色信息")
    @RequestMapping(value = "/queryUserRoleList", method = {RequestMethod.POST})
    public Result queryUserRoleList(SysUser user) {
        return roleService.queryUserRoleList(user);
    }

    @BussinessLog("查询角色权限列表")
    @RequestMapping(value = "/getRoleTree", method = {RequestMethod.POST})
    public Result getRoleTree(String roleId) {
        return roleService.getRoleTree(roleId);
    }
}
