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
import com.cofire.console.service.sytem.IReturnCodeService;
import com.cofire.dao.model.system.SysReturnCode;

@RestController
public class ReturnCodeController extends SystemBaseController {

    @Autowired
    private IReturnCodeService returnCodeService;

    @BussinessLog("查询返回码信息")
    @RequestMapping(value = "/returnCode/query", method = { RequestMethod.POST })
    public Result queryReturnCode(ParamItem paramItem, SysReturnCode returnCode) {
        return returnCodeService.query(paramItem, returnCode);
    }

    @BussinessLog("保存返回码信息")
    @RequestMapping(value = "/returnCode/save", method = { RequestMethod.POST })
    public Result saveReturnCode(String saveFlag, SysReturnCode returnCode) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return returnCodeService.add(returnCode);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return returnCodeService.upadte(returnCode);
        }
        return result;
    }

    @BussinessLog("删除返回码信息")
    @RequestMapping(value = "/returnCode/delete", method = { RequestMethod.POST })
    public Result deleteReturnCode(SysReturnCode returnCode) {
        return returnCodeService.delete(returnCode);
    }

}