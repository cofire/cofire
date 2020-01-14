package com.cofire.console.service.sytem.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.service.sytem.IJobLogService;
import com.cofire.dao.mapper.system.QtzJobLogMapper;
import com.cofire.dao.model.system.QtzJobLog;
import com.cofire.dao.model.system.QtzJobLogExample;

/**
 * @author ly
 * @version V1.0
 * @ClassName: JobLogServiceImpl
 * @Description:定时任务日志
 * @date 2019年12月4日
 */
@Service
public class JobLogServiceImpl implements IJobLogService {

    private final static Logger logger = LoggerFactory.getLogger(JobLogServiceImpl.class);
    @Autowired
    private QtzJobLogMapper jobLogMapper;

    /**
     * @param @param  paramItem
     * @param @param  jobLog
     * @param @return 参数
     * @return Result 返回类型
     * @Title: query
     * @author ly
     * @Description:分页查询定时任务日志信息
     */
    @Override
    public Result query(ParamItem paramItem, QtzJobLog jobLog) {
        logger.info("正在查询定时任务日志信息");
        Result result = new Result(true);
        QtzJobLogExample jobLogExample = new QtzJobLogExample();
        QtzJobLogExample.Criteria criteria = jobLogExample.createCriteria();
        if (null != jobLog) {
            if (StringUtils.isNotEmpty(jobLog.getJobId())) {
                criteria.andJobIdLike("%" + jobLog.getJobId() + "%");
            }
            if (StringUtils.isNotEmpty(jobLog.getIsSuccess())) {
                criteria.andIsSuccessEqualTo(jobLog.getIsSuccess());
            }
            if (StringUtils.isNotEmpty(jobLog.getRunTime())) {
                String auditTime = jobLog.getRunTime();
                String[] times = auditTime.split(",");
                criteria.andRunTimeBetween(times[0], times[1]);
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<QtzJobLog> jobLogList = jobLogMapper.selectByExample(jobLogExample);
        PageInfo<QtzJobLog> pageInfo = new PageInfo<>(jobLogList);
        result.setTotal(pageInfo.getTotal());
        result.setData(jobLogList);
        logger.info("查询定时任务日志信息完成");
        return result;
    }

}
