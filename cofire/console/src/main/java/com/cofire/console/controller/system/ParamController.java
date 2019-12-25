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

/**
 * @author ly
 * @version V1.0
 * @ClassName: ParamController
 * @Description:系统参数
 * @date 2019年12月4日
 */

@RestController
@RequestMapping(value = "/console/param")
public class ParamController extends SystemBaseController {

    @Autowired
    private IParamService paramService;

    @BussinessLog("查询系统参数信息")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryParam(ParamItem paramItem, SysParam param) {
        return paramService.query(paramItem, param);
    }

    @BussinessLog(value = "保存系统参数信息", operation = Constants.OPERATION_SAVE)
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Result saveParam(String operation, SysParam param) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return paramService.add(param);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return paramService.update(param);
        }
        return result;
    }

    @BussinessLog(value = "删除系统参数信息", operation = Constants.OPERATION_DELETE)
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result deleteParam(SysParam param) {
        return paramService.delete(param);
    }

}
