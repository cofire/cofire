package com.cofire.common.utils.context;

import com.cofire.common.constant.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ly
 * @Description
 * @date 2020/01/13
 **/
public class HttpServletRequestReplacedFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        String contentType = "";
        if (StringUtils.isNotEmpty(request.getContentType())) {
            contentType = request.getContentType().trim();
        }
        if (request instanceof HttpServletRequest) {
            if (StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_JSON)
                    || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_TEXT_JSON)
                    || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_JSON_N)
                    || StringUtils.equalsIgnoreCase(contentType, Constants.CONTENT_TYPE_TEXT_JSON_N)) {
                requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
            }
        }
        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}

