package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IJobLogService;
import com.cofire.dao.model.system.QtzJobLog;

@RestController
public class JobLogController extends SystemBaseController {

    @Autowired
    private IJobLogService jobLogService;

    @BussinessLog("查询定时任务执行日志")
    @RequestMapping(value = "/jobLog/query", method = { RequestMethod.POST })
    public Result queryJobLog(ParamItem paramItem, QtzJobLog jobLog) {
        return jobLogService.query(paramItem, jobLog);
    }

}
