package com.cofire.console.controller.system;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.model.system.SysUser;

/**
 * 
 * @ClassName: UserController
 * @Description:用户管理
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/console/user")
public class UserController extends SystemBaseController {

    @Autowired
    private IUserService userService;

    @BussinessLog("查询用户信息")
    @RequestMapping(value = "/query", method = { RequestMethod.POST })
    public Result queryRole(ParamItem paramItem, SysUser user) {
        return userService.query(paramItem, user);
    }

    @BussinessLog("保存用户信息")
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public Result saveUser(String operation, SysUser user) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return userService.add(user);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return userService.update(user);
        }
        return result;
    }

    @BussinessLog("删除用户信息")
    @RequestMapping(value = "/delete", method = { RequestMethod.POST })
    public Result deleteUser(String userId) {
        return userService.delete(userId);
    }

    @BussinessLog("用户角色设置")
    @RequestMapping(value = "/saveUserRole", method = { RequestMethod.POST })
    public Result saveUserRole(String userId, String roleIds) {
        return userService.saveUserRole(userId, roleIds);
    }

    @BussinessLog("用户重置密码")
    @RequestMapping(value = "/restPassWord", method = { RequestMethod.POST })
    public Result restPassWord(String userId) {
        return userService.restPassWord(userId);
    }

    @BussinessLog("用户修改密码")
    @RequestMapping(value = "/changePassWord", method = { RequestMethod.POST })
    public Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord) {
        return userService.changePassWord(currentPassWord, newPassWord, confirmNewPassWord);
    }

    @BussinessLog("导出用户信息")
    @RequestMapping(value = "/exportExcel")
    public void exportExcel(SysUser user, HttpServletResponse response) {
        userService.exportExcel(user, response);
    }
}
