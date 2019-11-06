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
import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.model.system.SysUser;

@RestController
public class UserController extends SystemBaseController {
    // private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @BussinessLog("查询用户信息")
    @RequestMapping(value = "/user/query", method = { RequestMethod.POST })
    public Result queryRole(ParamItem paramItem, SysUser user) {
        return userService.query(paramItem, user);
    }

    @BussinessLog("保存用户信息")
    @RequestMapping(value = "/user/save", method = { RequestMethod.POST })
    public Result saveUser(String operation, SysUser user) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return userService.add(user);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return userService.upadte(user);
        }
        return result;
    }

    @BussinessLog("删除用户信息")
    @RequestMapping(value = "/user/delete", method = { RequestMethod.POST })
    public Result deleteUser(String userId) {
        return userService.delete(userId);
    }

    @BussinessLog("用户角色设置")
    @RequestMapping(value = "/user/saveUserRole", method = { RequestMethod.POST })
    public Result saveUserRole(String userId, String roleIds) {
        return userService.saveUserRole(userId, roleIds);
    }

    @BussinessLog("用户重置密码")
    @RequestMapping(value = "/user/restPassWord", method = { RequestMethod.POST })
    public Result restPassWord(String userId) {
        return userService.restPassWord(userId);
    }

    @BussinessLog("用户修改密码")
    @RequestMapping(value = "/user/changePassWord", method = { RequestMethod.POST })
    public Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord) {
        return userService.changePassWord(currentPassWord, newPassWord, confirmNewPassWord);
    }
}
