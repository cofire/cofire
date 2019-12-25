package com.cofire.common.utils.spring;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author ly
 * @version V1.0
 * @ClassName: SpringContextUtils
 * @Description:spring工具类
 * @date 2019年12月4日
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SpringContextUtils.class);

    private ApplicationContext applicationContext = null;
    private ServletContext servletContext = null;

    private static SpringContextUtils instance = new SpringContextUtils();

    private SpringContextUtils() {
    }

    public final static SpringContextUtils getInstance() {
        if (instance == null) {
            instance = new SpringContextUtils();
        }
        return instance;
    }

    public static Object getBean(String beanName) {
        if (logger.isTraceEnabled()) {
            logger.trace(new StringBuilder().append("Try to get bean [").append(beanName).append("] from spring context.").toString());
        }
        Object beans = null;
        try {
            beans = instance.applicationContext.getBean(beanName);
        } catch (BeansException de) {
            logger.error(new StringBuilder().append("Bean [").append(beanName).append("] inexistence!").toString(), de);
            throw new RuntimeException("The Bean is InExistence");
        }
        return beans;
    }

    public static <T extends Object> T getBean(Class<T> clazz) {
        if (logger.isTraceEnabled()) {
            logger.trace(new StringBuilder().append("Try to get bean [").append(clazz.getName()).append("] from spring context.").toString());
        }
        Object beans = null;
        try {
            beans = instance.applicationContext.getBean(clazz);
        } catch (BeansException de) {
            logger.error(new StringBuilder().append("Bean [").append(clazz.getName()).append("] inexistence!").toString(), de);
            throw new RuntimeException("The Bean is InExistence");
        }
        return (T) beans;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> T getBean(String beanName, Class<T> clazz) throws Exception {
        Object beanIns = SpringContextUtils.getBean(beanName);
        if (beanIns == null) {
            return null;
        }
        return (T) beanIns;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        getInstance().applicationContext = applicationContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}
