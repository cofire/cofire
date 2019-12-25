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
import com.cofire.console.service.sytem.IDictService;
import com.cofire.dao.model.system.SysDict;

/**
 * @author ly
 * @version V1.0
 * @ClassName: DictController
 * @Description:数据字典
 * @date 2019年12月4日
 */
@RestController
@RequestMapping(value = "/console/dict")
public class DictController extends SystemBaseController {

    @Autowired
    private IDictService dictService;

    @BussinessLog("查询数据字典信息")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryDict(ParamItem paramItem, SysDict dict) {
        return dictService.query(paramItem, dict);
    }

    @BussinessLog(value = "保存数据字典信息", operation = Constants.OPERATION_SAVE)
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Result saveDict(String operation, SysDict dict) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return dictService.add(dict);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return dictService.update(dict);
        }
        return result;
    }

    @BussinessLog(value = "删除数据字典信息", operation = Constants.OPERATION_DELETE)
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result deleteDict(SysDict dict) {
        return dictService.delete(dict);
    }

}
