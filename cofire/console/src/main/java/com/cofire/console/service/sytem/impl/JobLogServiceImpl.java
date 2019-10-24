package com.cofire.console.service.sytem.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.console.service.sytem.IJobLogService;
import com.cofire.dao.mapper.system.QtzJobLogMapper;
import com.cofire.dao.model.system.QtzJobLog;
import com.cofire.dao.model.system.QtzJobLogExample;

@Service
public class JobLogServiceImpl implements IJobLogService {

    private final static Logger logger = LoggerFactory.getLogger(JobLogServiceImpl.class);
    @Autowired
    private QtzJobLogMapper jobLogMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询定时任务日志信息
     * @param @param paramItem
     * @param @param jobLog
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, QtzJobLog jobLog) {
        logger.info("正在查询定时任务日志信息");
        Result result = new Result();
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
        Long count = 0L;
        try {
            // 获取数据总和
            count = jobLogMapper.countByExample(jobLogExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                jobLogExample.setDatabaseId(Constants.MYSQL);
                jobLogExample.setOrderByClause("sid DESC");
                jobLogExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<QtzJobLog> jobLogList = null;
        try {
            // 获取数据集
            jobLogList = jobLogMapper.selectPageByExample(jobLogExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询定时任务日志信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
        result.setData(jobLogList);
        logger.info("查询定时任务日志信息完成");
        return result;
    }

}
