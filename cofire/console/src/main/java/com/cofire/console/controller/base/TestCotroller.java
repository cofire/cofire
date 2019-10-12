package com.cofire.console.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.quartz.QuartzJobConfig;

@RestController
@RequestMapping("/test")
public class TestCotroller {
    private final static Logger logger = LoggerFactory.getLogger(TestCotroller.class);

    @RequestMapping("/registerQuartzJob")
    public void registerQuartzJob() {
        try {
            QuartzJobConfig.registerQuartzJob();
        } catch (Exception e) {
            logger.info(e.toString());
            logger.info("定时任务注册失败");
        }
    }

    @RequestMapping("/shutdownQuartzJob")
    public void shutdownQuartzJob() {
        try {
            QuartzJobConfig.shutdownQuartzJob();
        } catch (Exception e) {
            logger.info(e.toString());
            logger.info("关闭任务注册失败");
        }
    }

    @RequestMapping("/standbyQuartzJob")
    public void standbyQuartzJob() {
        try {
            QuartzJobConfig.standbyQuartzJob();
        } catch (Exception e) {
            logger.info(e.toString());
            logger.info("关闭任务注册失败");
        }
    }
}
