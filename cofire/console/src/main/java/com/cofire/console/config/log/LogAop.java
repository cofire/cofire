package com.cofire.console.config.log;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cofire.common.constant.Constants;
import com.cofire.common.utils.context.HttpContext;
import com.cofire.common.utils.string.DateUtils;
import com.cofire.console.config.log.factory.LogFactory;
import com.cofire.console.config.log.factory.LogTaskFactory;
import com.cofire.dao.model.system.SysOperateAudit;
import com.cofire.dao.model.system.SysUser;

/**
 * 
 * @ClassName: LogAop
 * @Description: 业务日志记录
 * @date 2019年4月30日
 *
 */
@Aspect
@Component
public class LogAop {

    private Logger logger = LoggerFactory.getLogger(LogAop.class);

    ThreadLocal<SysOperateAudit> aopLog = new ThreadLocal<>();
    SysOperateAudit operateAudit = new SysOperateAudit();

    @Pointcut(value = "@annotation(com.cofire.console.config.log.BussinessLog)")
    public void cutService() {
    }

    @Before("cutService()")
    public void doBefore(JoinPoint point) throws Throwable {
        logger.info("调用前");
        // 获取当前用户
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
        String userId = "";
        String sessionId = "";
        // 用户为空时，不记日志
        if (null != user) {
            userId = user.getUserId();
            sessionId = (String) session.getId();
        }
        // 获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();
        // 获取请求的类名
        String className = point.getTarget().getClass().getName();
        // 获取请求参数
        Map<String, String> obj2 = HttpContext.getRequestParameters();
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        logger.info("接口说明：" + bussinessName);
        logger.info("接口参数：" + obj2.toString());
        // 获取请求ip
        String ip = HttpContext.getClientIP();
        String reqURI = HttpContext.getRequestURI();
        logger.info("请求用户id：" + userId);
        logger.info("请求用户Session：" + sessionId);
        logger.info("请求方法：" + className + "." + methodName);
        logger.info("请求Ip：" + ip);
        logger.info("请求URI：" + reqURI);
        operateAudit = LogFactory.createOperateAudit(ip, sessionId, reqURI, userId, bussinessName, obj2.toString());
        aopLog.set(operateAudit);
    }

    @AfterReturning(returning = "ret", pointcut = "cutService()")
    public void doAfterReturning(Object ret) throws Throwable {
        String result = JSON.toJSONString(ret);
        if (result.length() > 1000) {
            result = result.substring(0, 1000);
        }
        SysOperateAudit operateAudit = aopLog.get();
        operateAudit.setResult(result);
        operateAudit.setReturnTime(DateUtils.dataTimeToNumber(new Date()));
        LogManager.me().executeLog(LogTaskFactory.bussinessLog(operateAudit));
    }

}
