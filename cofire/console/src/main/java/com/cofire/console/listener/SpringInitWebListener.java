/**
 *
 */
package com.cofire.console.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cofire.common.utils.spring.SpringContextUtils;

/**
 *
 * @ClassName: SpringInitWebListener
 * @Description: 读取Spring配置，初始化ApplicationContext. 在web应用中一般用ContextLoaderListener加载webapplication,
 *               如果需要在action之外或者control类之外获取webapplication思路之一是，单独写个类放在static变量中
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@WebListener
public class SpringInitWebListener extends ContextLoaderListener {
    private final static Logger logger = LoggerFactory.getLogger(SpringInitWebListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Start to init SpringContextLoader at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }
        // super.contextInitialized(event);
        System.out.println("初始化ApplicationContext");

        ServletContext servletContext = event.getServletContext();

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        SpringContextUtils.getInstance().setApplicationContext(applicationContext);

        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Finish to init SpringContextLoader at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Start to destory SpringContextLoader at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }
        super.contextDestroyed(event);

        if (logger.isDebugEnabled()) {
            logger.debug(new StringBuilder().append("---------- Finish to destory SpringContextLoader at ").append(System.currentTimeMillis())
                    .append(" --------------").toString());
        }
    }
}
