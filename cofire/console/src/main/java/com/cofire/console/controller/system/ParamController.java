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
import com.cofire.console.service.sytem.IParamService;
import com.cofire.dao.model.system.SysParam;

@RestController
public class ParamController extends SystemBaseController {

    @Autowired
    private IParamService paramService;

    @BussinessLog("查询系统参数信息")
    @RequestMapping(value = "/param/query", method = { RequestMethod.POST })
    public Result queryParam(ParamItem paramItem, SysParam param) {
        return paramService.query(paramItem, param);
    }

    @BussinessLog("保存系统参数信息")
    @RequestMapping(value = "/param/save", method = { RequestMethod.POST })
    public Result saveParam(String saveFlag, SysParam param) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return paramService.add(param);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return paramService.upadte(param);
        }
        return result;
    }

    @BussinessLog("删除系统参数信息")
    @RequestMapping(value = "/param/delete", method = { RequestMethod.POST })
    public Result deleteParam(SysParam param) {
        return paramService.delete(param);
    }

}
