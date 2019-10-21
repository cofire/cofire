package com.cofire.console.service.sytem.impl;

import java.util.List;

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
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IJobService;
import com.cofire.dao.mapper.system.QtzJobMapper;
import com.cofire.dao.model.system.QtzJob;
import com.cofire.dao.model.system.QtzJobExample;
import com.cofire.quartz.QuartzJobConfig;

@Service
public class JobServiceImpl implements IJobService {

    private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
    @Autowired
    private QtzJobMapper jobMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询定时任务信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, QtzJob job) {
        logger.info("正在查询定时任务信息");
        Result result = new Result();
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
        Long count = 0L;
        try {
            // 获取数据总和
            count = jobMapper.countByExample(jobExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                jobExample.setDatabaseId(Constants.MYSQL);
                jobExample.setOrderByClause("job_id");
                jobExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<QtzJob> jobList = null;
        try {
            // 获取数据集
            jobList = jobMapper.selectPageByExample(jobExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询定时任务信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
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
            job.setModifier(CurrentUserUtil.getCurentUserId());
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
     * 
     * @Title: upadte
     * @author ly
     * @Description:定时任务信息
     * @param @param job
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result upadte(QtzJob job) {
        Result result = new Result();
        try {
            logger.info("正在修改定时任务信息");
            job.setModifier(CurrentUserUtil.getCurentUserId());
            job.setModifyTime(Util.getCurrentDateTimeString());
            jobMapper.updateByPrimaryKeySelective(job);
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
     * 
     * @Title: delete
     * @author ly
     * @Description:删除定时任务信息
     * @param @param job
     * @param @return 参数
     * @return Result 返回类型
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
