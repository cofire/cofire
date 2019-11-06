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
import com.cofire.console.service.sytem.IJobService;
import com.cofire.dao.model.system.QtzJob;

@RestController
public class JobController extends SystemBaseController {

    @Autowired
    private IJobService jobService;

    @BussinessLog("查询定时任务信息")
    @RequestMapping(value = "/job/query", method = { RequestMethod.POST })
    public Result queryJob(ParamItem paramItem, QtzJob job) {
        return jobService.query(paramItem, job);
    }

    @BussinessLog("保存定时任务信息")
    @RequestMapping(value = "/job/save", method = { RequestMethod.POST })
    public Result saveJob(String operation, QtzJob job) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return jobService.add(job);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return jobService.upadte(job);
        }
        return result;
    }

    @BussinessLog("删除定时任务信息")
    @RequestMapping(value = "/job/delete", method = { RequestMethod.POST })
    public Result deleteJob(QtzJob job) {
        return jobService.delete(job);
    }

}
