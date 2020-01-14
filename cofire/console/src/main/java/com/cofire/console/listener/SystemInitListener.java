package com.cofire.console.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofire.console.common.impl.SystemService;
import com.cofire.quartz.QuartzJobConfig;

/**
 * @author ly
 * @version V1.0
 * @ClassName: SystemInitListener
 * @Description:系统启动监听器
 * @date 2019年12月4日
 */

@WebListener
public class SystemInitListener implements ServletContextListener {
    private final static Logger logger = LoggerFactory.getLogger(SystemInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Start to init ServletContextListener  at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }
        logger.info("正在初始化全局变量");
        systemStartup(sce.getServletContext());
        logger.info("初始化全局变量完成");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Start to Destroy ServletContextListener  at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }

        // 关闭Quartz
        logger.info("开始关闭Quartz");
        QuartzJobConfig.shutdownQuartzJob();
        logger.info("Quartz已关闭");

    }

    /**
     * @param servletContext
     * @return void 返回类型
     * @Title: systemStartup
     * @Description:初始化全局变量
     */
    private void systemStartup(ServletContext servletContext) {
        if (logger.isDebugEnabled()) {
            logger.debug(
                    new StringBuilder().append("---------- Start to 初始化全局变量  at ").append(System.currentTimeMillis()).append(" --------------").toString());
        }
        SystemService.initSysParam();
        SystemService.initSysDict();
        SystemService.initRerurnCode();

        try {
            QuartzJobConfig.registerQuartzJob();
        } catch (Exception e) {
            logger.info(e.toString());
            logger.info("定时任务注册失败");
        }
    }

}
