package com.cofire.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofire.common.utils.spring.SpringContextUtils;
import com.cofire.dao.mapper.system.QtzJobMapper;
import com.cofire.dao.model.system.QtzJob;
import com.cofire.dao.model.system.QtzJobExample;

public class QuartzJobConfig {
    // 常量
    private static Scheduler scheduler = SpringContextUtils.getBean(Scheduler.class);;
    private final static String JOB_GROUP = "jobGroup";
    private final static Logger logger = LoggerFactory.getLogger(QuartzJobConfig.class);

    private final static QtzJobMapper jobMapper = SpringContextUtils.getBean(QtzJobMapper.class);

    /**
     * 
     * @Title: registerQuartzJob
     * @author ly
     * @Description:定时任务注册
     * @param @throws Exception 参数
     * @return void 返回类型
     */
    public static void registerQuartzJob() throws Exception {
        logger.info("准备注册定时任务");
        QtzJobExample jobExample = new QtzJobExample();
        QtzJobExample.Criteria criteria = jobExample.createCriteria();
        criteria.andIsDelEqualTo("0");
        List<QtzJob> jobList = jobMapper.selectByExample(jobExample);
        logger.info("总共有" + jobList.size() + "个定时任务");
        if (jobList != null && jobList.size() > 0) {
            for (QtzJob job : jobList) {
                try {
                    String cronExpression = getCronExpression(job);
                    JobDetail jobDetail = JobBuilder.newJob(QuartzJobBusiness.class).withIdentity(job.getJobName(), JOB_GROUP).withDescription(job.getJobDesc())
                            .build();
                    // 触发时间点
                    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
                    Trigger trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobId(), JOB_GROUP).startNow().withSchedule(cronScheduleBuilder).build();
                    // 交由Scheduler安排触发
                    scheduler.scheduleJob(jobDetail, trigger);
                    logger.info("注册名为" + job.getJobName() + ",ID为" + job.getJobId() + "的任务成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("注册名为" + job.getJobName() + ",ID为" + job.getJobId() + "的任务失败");
                }
            }
        }
        scheduler.start();
        logger.info("Quartz任务注册成功");
    }

    /**
     * 
     * @Title: shutdownQuartzJob
     * @Description:关闭所有定时任务，且不可重新注册
     * @return void 返回类型
     */
    public static void shutdownQuartzJob() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("关闭QuartzJob异常");
        }
    }

    /**
     * 
     * @Title: standbyQuartzJob
     * @Description:暂停且清除所有的定时任务
     * @return void 返回类型
     */
    public static void standbyQuartzJob() {
        try {
            scheduler.standby();
            scheduler.clear();
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("关闭QuartzJob异常");
        }
    }

    /**
     * 
     * @Title: getCronExpression
     * @Description:组装cron表达式
     * @param job
     * @return
     * @return String 返回类型
     */
    public static String getCronExpression(QtzJob job) {
        String cronExpression = null;

        // CronExpression格式：秒 分钟 小时 天数 月 星期 年份 详细说明 http://www.iteye.com/topic/582119
        String flag = "*"; // 表示所有值 不适用表达星期
        String replaceFlag = "?"; // ? 号只能用在日和周域上，但是不能在这两个域上同时使用。

        String year = job.getYear();
        String month = job.getMonth();
        String date = job.getDate();
        String day = job.getDay();
        String hour = job.getHour();
        String minute = job.getMinute();
        String second = job.getSecond();

        if (day == flag) {
            day = replaceFlag;
        } // 替换星期字符域

        // 如果星期字符域有数据，日期字符域替换为replaceFlag"?"
        if (!(day == flag || day == replaceFlag)) {
            date = replaceFlag;
        }

        cronExpression = second + " " + minute + " " + hour + " " + date + " " + month + " " + day + " " + year;

        return cronExpression;
    }
}
