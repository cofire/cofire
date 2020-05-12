package com.cofire.console.interceptor;

import com.cofire.common.constant.Constants;
import com.cofire.common.utils.context.HttpContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * @ClassName CommonInterceptor
 * @Author xudong.zhang_c
 * @Date 2019年09月30日 23:22:44
 **/
@Component
@Service
public class CommonInterceptor implements AsyncHandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("请求ip:{}", HttpContext.getIp());
        StringBuilder sb = new StringBuilder("请求地址为：").append(request.getRequestURI()).append(" 请求参数为：");
        String contentType = "";
        if (StringUtils.isNotEmpty(request.getContentType())) {
            contentType = request.getContentType().trim();
        }
        contentType = contentType.replace(" ", "");
        if (StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_FORM)
                || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_FORM_N)) {
            request.setAttribute(Constants.IS_JSON_PARAM, false);
            Enumeration paramNames = request.getParameterNames();
            boolean hasParam = false;
            while (paramNames.hasMoreElements()) {
                hasParam = true;
                String paramName = (String) paramNames.nextElement();
                String value = request.getParameter(paramName);
                sb.append(paramName).append("[").append(value).append("]");
            }
            if (!hasParam) {
                sb.append("无");
            }
        } else if (StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_JSON)
                || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_TEXT_JSON)
                || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_JSON_N)
                || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_TEXT_JSON_N)) {
            String json = "";
            request.setAttribute(Constants.IS_JSON_PARAM, true);
            try {
                ServletInputStream in = request.getInputStream();
                String content = IOUtils.toString(in, Constants.CHARSET_UTF_8);
                json = URLDecoder.decode(content, Constants.CHARSET_UTF_8);
                json = json.substring(json.indexOf("=") + 1);
                sb.append(json);
                request.setAttribute(Constants.JSON_PARAM, json);
            } catch (IOException e) {
                logger.error("获取请求异常，{}", e.getMessage(), e);
            }
        } else if (StringUtils.isEmpty(contentType)) {
            return true;
        } else {
            logger.error("请求content-type设置错误，{}", contentType);
            throw new Exception("请求content-type设置错误");
        }

        logger.info(sb.toString());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }
}
