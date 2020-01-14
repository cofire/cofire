package com.cofire.quartz;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cofire.common.utils.spring.SpringContextUtils;
import com.cofire.common.utils.string.DateUtils;
import com.cofire.dao.mapper.system.QtzJobLogMapper;
import com.cofire.dao.mapper.system.QtzJobMapper;
import com.cofire.dao.model.system.QtzJob;
import com.cofire.dao.model.system.QtzJobLog;
import com.cofire.quartz.service.TestQtz;

public class QuartzJobBusiness extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(QuartzJobBusiness.class);
    private final static QtzJobMapper jobMapper = SpringContextUtils.getBean(QtzJobMapper.class);
    private final static QtzJobLogMapper jobLogMapper = SpringContextUtils.getBean(QtzJobLogMapper.class);

    @SuppressWarnings("unused")
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        // 判断一下本机ip是多少，只在测试服务器和开发服务器上运行quartzjob
        String localip = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String localname = ia.getHostName();
            localip = ia.getHostAddress();
            logger.info("本机名称是：" + localname);
            logger.info("本机的ip是 ：" + localip);
            logger.info("本机的ia是 ：" + ia);
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
        // TB_JOB表ID作为Trigger的key名称
        String jobId = context.getTrigger().getKey().getName();
        logger.info("定时任务id：" + jobId);
        QtzJob job = null;
        String errorMsg = "";

        try {
            job = jobMapper.selectByPrimaryKey(jobId);
        } catch (Exception e) {
            logger.error("读取数据库失败，失败原因：" + e.getMessage());
            errorMsg = e.getMessage();
        }

        if (null == job) {
            logger.info("没有找到id为:" + jobId + "的任务");
        } else {
            if (!"1".equals(job.getIsDel())) {
                logger.info("开始执行名为:" + job.getJobName() + "的任务");
                try {
                    execute(job);
                } catch (Exception e) {
                    logger.info("开始执行名为:" + job.getJobName() + "的任务异常");
                    logger.error(e.getMessage());
                    errorMsg = e.getMessage();
                    if (errorMsg.length() > 2000) {
                        errorMsg = errorMsg.substring(0, 2000);
                    }
                }
            }
        }

        QtzJobLog jobLog = new QtzJobLog();
        jobLog.setIp(localip);
        jobLog.setJobId(jobId);
        jobLog.setRunTime(DateUtils.dataTimeToNumber(new Date()));
        if ("".equals(errorMsg)) {
            jobLog.setIsSuccess("1");
        } else {
            jobLog.setIsSuccess("0");
            jobLog.setMessage(errorMsg);
        }
        try {
            jobLogMapper.insert(jobLog);
        } catch (Exception e) {
            logger.info("记录定时任务日志失败：" + e.getMessage());
        }
    }

    private void execute(QtzJob job) throws Exception {
        String jobId = job.getJobId();
        switch (jobId) {
            case ("test"):
                TestQtz testQtz = SpringContextUtils.getBean(TestQtz.class);
                testQtz.execute();
                break;
            case ("02"):
                break;
            default:
                break;
        }

    }

}
