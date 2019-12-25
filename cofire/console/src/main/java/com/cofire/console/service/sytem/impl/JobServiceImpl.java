package com.cofire.console.service.sytem.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.string.StringUtil;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IJobService;
import com.cofire.dao.mapper.system.QtzJobMapper;
import com.cofire.dao.model.system.QtzJob;
import com.cofire.dao.model.system.QtzJobExample;
import com.cofire.quartz.QuartzJobConfig;

/**
 * @author ly
 * @version V1.0
 * @ClassName: JobServiceImpl
 * @Description:定时任务管理
 * @date 2019年12月4日
 */
@Service
public class JobServiceImpl implements IJobService {

    private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
    @Autowired
    private QtzJobMapper jobMapper;

    /**
     * @param @param  paramItem
     * @param @param  user
     * @param @return 参数
     * @return Result 返回类型
     * @Title: query
     * @author ly
     * @Description:分页查询定时任务信息
     */
    @Override
    public Result query(ParamItem paramItem, QtzJob job) {
        logger.info("正在查询定时任务信息");
        Result result = new Result(true);
        QtzJobExample jobExample = new QtzJobExample();
        QtzJobExample.Criteria criteria = jobExample.createCriteria();
        if (null != job) {
            if (StringUtils.isNotEmpty(job.getJobId())) {
                criteria.andJobIdLike("%" + job.getJobId() + "%");
            }
            if (StringUtils.isNotEmpty(job.getJobName())) {
                criteria.andJobNameLike("%" + job.getJobName() + "%");
            }
            if (StringUtils.isNotEmpty(job.getJobDesc())) {
                criteria.andJobDescLike("%" + job.getJobDesc() + "%");
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<QtzJob> jobList = jobMapper.selectByExample(jobExample);
        PageInfo<QtzJob> pageInfo = new PageInfo<>(jobList);
        result.setTotal(pageInfo.getTotal());
        result.setData(jobList);
        logger.info("查询定时任务信息完成");
        return result;
    }

    /**
     * 新增定时任务信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(QtzJob job) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(job, "jobId", "jobName")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        QtzJob jobTmp = jobMapper.selectByPrimaryKey(job.getJobId());
        if (jobTmp != null) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            job.setModifier(CurrentUserUtil.getCurrentUserId());
            job.setModifyTime(Util.getCurrentDateTimeString());
            jobMapper.insertSelective(job);
            QuartzJobConfig.standbyQuartzJob();
            QuartzJobConfig.registerQuartzJob();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增定时任务信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * @param @param  job
     * @param @return 参数
     * @return Result 返回类型
     * @Title: update
     * @author ly
     * @Description:定时任务信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(QtzJob job) {
        Result result = new Result();
        try {
            logger.info("正在修改定时任务信息");
            QtzJobExample example = new QtzJobExample();
            QtzJobExample.Criteria criteria = example.createCriteria();
            criteria.andJobIdEqualTo(job.getJobId());
            job.setModifier(CurrentUserUtil.getCurrentUserId());
            job.setModifyTime(Util.getCurrentDateTimeString());
            jobMapper.updateByExample(job, example);
            QuartzJobConfig.standbyQuartzJob();
            QuartzJobConfig.registerQuartzJob();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改定时任务信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * @param @param  job
     * @param @return 参数
     * @return Result 返回类型
     * @Title: delete
     * @author ly
     * @Description:删除定时任务信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(QtzJob job) {
        logger.info("正在删除定时任务信息");
        Result result = new Result();
        try {
            logger.info("开始删除定时任务信息");
            // 根据主键删除对应记录
            jobMapper.deleteByPrimaryKey(job.getJobId());
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除定时任务信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
