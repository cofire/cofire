/**
 *
 */
package com.cofire.console.listener;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @ClassName: HttpSessionMessageListener
 * @Description:session管理
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@WebListener
@SuppressWarnings({"rawtypes", "unchecked"})
public class HttpSessionMessageListener implements HttpSessionListener {

    private static HashMap sessionMap = new HashMap();
    private static final Logger log = LoggerFactory.getLogger(HttpSessionMessageListener.class);

    public static HashMap getSessionMap() {
        return sessionMap;
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        synchronized (HttpSessionMessageListener.class) {
            sessionMap.put(session.getId(), session);
            log.debug("The current count of session is [" + sessionMap.size() + "]");
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        synchronized (HttpSessionMessageListener.class) {

            sessionMap.remove(session.getId());
            log.debug("The current count of session is [" + sessionMap.size() + "]");
        }

    }

}
