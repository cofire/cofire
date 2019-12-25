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

/**
 * @author ly
 * @version V1.0
 * @ClassName: JobController
 * @Description:定时任务
 * @date 2019年12月4日
 */
@RestController
@RequestMapping(value = "/console/job")
public class JobController extends SystemBaseController {

    @Autowired
    private IJobService jobService;

    @BussinessLog("查询定时任务信息")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryJob(ParamItem paramItem, QtzJob job) {
        return jobService.query(paramItem, job);
    }

    @BussinessLog(value = "保存定时任务信息", operation = Constants.OPERATION_SAVE)
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Result saveJob(String operation, QtzJob job) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return jobService.add(job);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return jobService.update(job);
        }
        return result;
    }

    @BussinessLog(value = "删除定时任务信息", operation = Constants.OPERATION_DELETE)
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result deleteJob(QtzJob job) {
        return jobService.delete(job);
    }

}
