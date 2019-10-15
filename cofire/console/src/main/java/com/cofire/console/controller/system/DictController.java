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
import com.cofire.console.service.sytem.IDictService;
import com.cofire.dao.model.system.SysDict;

@RestController
public class DictController extends SystemBaseController {

    @Autowired
    private IDictService dictService;

    @BussinessLog("查询数据字典信息")
    @RequestMapping(value = "/dict/query", method = { RequestMethod.POST })
    public Result queryDict(ParamItem paramItem, SysDict dict) {
        return dictService.query(paramItem, dict);
    }

    @BussinessLog("保存数据字典信息")
    @RequestMapping(value = "/dict/save", method = { RequestMethod.POST })
    public Result saveDict(String saveFlag, SysDict dict) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return dictService.add(dict);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return dictService.upadte(dict);
        }
        return result;
    }

    @BussinessLog("删除数据字典信息")
    @RequestMapping(value = "/dict/delete", method = { RequestMethod.POST })
    public Result deleteDict(SysDict dict) {
        return dictService.delete(dict);
    }

}
