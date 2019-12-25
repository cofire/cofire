package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IOperateAuditService;
import com.cofire.dao.model.system.SysOperateAudit;

/**
 * @author ly
 * @version V1.0
 * @ClassName: OperateAuditController
 * @Description:操作日志
 * @date 2019年12月4日
 */
@RestController
@RequestMapping(value = "/console/operateAudit")
public class OperateAuditController extends SystemBaseController {

    @Autowired
    private IOperateAuditService operateAuditService;

    @BussinessLog("查询操作日志")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryOperateAudit(ParamItem operateAuditItem, SysOperateAudit operateAudit) {
        return operateAuditService.query(operateAuditItem, operateAudit);
    }

}
