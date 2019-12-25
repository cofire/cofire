package com.cofire.console.config.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author ly
 * @version V1.0
 * @ClassName: LogManager
 * @Description:日志管理器
 * @date 2019年12月4日
 */
public class LogManager {

    /**
     * 日志记录操作延时
     */
    private final int OPERATE_DELAY_TIME = 10;

    /**
     * 异步操作记录日志的线程池
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10,
            new BasicThreadFactory.Builder().namingPattern("logManage-%d").daemon(true).build());

    private LogManager() {
    }

    public static LogManager logManager = new LogManager();

    public static LogManager me() {
        return logManager;
    }

    public void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
