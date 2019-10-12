package com.cofire.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.dao.mapper.system.QtzJobMapper;
import com.cofire.quartz.QuartzJobBusiness;

@Service
public class TestQtz {
    private final static Logger logger = LoggerFactory.getLogger(QuartzJobBusiness.class);
    @Autowired
    private QtzJobMapper jobMapper;

    public void execute() {
        logger.info("开始执行测试定时任务");
        System.out.println(jobMapper.selectByPrimaryKey("test"));
        logger.info("执行测试定时任务结束");
    }
}
