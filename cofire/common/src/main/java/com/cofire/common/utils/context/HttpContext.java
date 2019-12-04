package com.cofire.common.utils.context;

import java.net.InetAddress;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @ClassName: HttpContext
 * @Description:HttpContext 工具类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class HttpContext {

    private static Logger logger = LoggerFactory.getLogger(HttpContext.class);

    private static final String UNKNOW = "unknow";
    private static final String X_FORWARDED_FOR = "x-forwarded-for";
    private static final String PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String LOCALHOST_IP = "127.0.0.1";
    private static final int IP_ADDRESS_MIN_LENGTH = 15;
    private static final String IP_ADDRESS_SPLITTER = ",";

    /**
     * 获取请求的ip地址
     *
     */
    public static String getIp() {
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) {
            return "127.0.0.1";
        } else {
            return request.getRemoteHost();
        }
    }

    /**
     * 
     * @Title: getIpAddr
     * @Description:获取请求的ip
     * @param request
     * @return
     * @return String 返回类型
     */
    public static String getClientIp() {
        HttpServletRequest request = HttpContext.getRequest();
        String ipAddress = null;
        ipAddress = request.getHeader(X_FORWARDED_FOR);
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader(WL_PROXY_CLIENT_IP);
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOW.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IP.equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
                ipAddress = inet.getHostAddress();
            }
        }
        /** 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割 */
        if (ipAddress != null && ipAddress.length() > IP_ADDRESS_MIN_LENGTH) {
            if (ipAddress.indexOf(IP_ADDRESS_SPLITTER) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(IP_ADDRESS_SPLITTER));
            }
        }
        return ipAddress;
    }

    /**
     * 获取当前请求的Request对象
     *
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        } else {
            return requestAttributes.getRequest();
        }
    }

    /**
     * 获取当前请求的Response对象
     *
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        } else {
            return requestAttributes.getResponse();
        }
    }

    /**
     * 获取请求路径
     *
     */
    public static String getRequestUri() {
        HttpServletRequest request = HttpContext.getRequest();
        return request.getRequestURI();
    }

    /**
     * 获取所有请求的值
     *
     */
    public static Map<String, String> getRequestParameters() {
        HashMap<String, String> values = new HashMap<>(30);
        HttpServletRequest request = HttpContext.getRequest();
        if (request == null) {
            return values;
        }
        Enumeration<?> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paramName = (String) enums.nextElement();
            String paramValue = request.getParameter(paramName);
            values.put(paramName, paramValue);
        }
        return values;
    }

}
