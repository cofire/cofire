package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.constant.CodeEnum;
import com.cofire.common.utils.constant.Constants;
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
    public Result query(ParamItem paramItem, SysUser user) {
        return userService.query(paramItem, user);
    }

    @BussinessLog("保存用户信息")
    @RequestMapping(value = "/user/save", method = { RequestMethod.POST })
    public Result saveUser(String saveFlag, SysUser user) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return userService.add(user);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return userService.upadte(user);
        }
        return result;
    }

    @BussinessLog("删除用户信息")
    @RequestMapping(value = "/user/delete", method = { RequestMethod.POST })
    public Result deleteUser(SysUser user) {
        return userService.delete(user);
    }

}
