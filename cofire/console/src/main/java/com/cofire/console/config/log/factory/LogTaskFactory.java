package com.cofire.console.config.log.factory;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;

import com.cofire.common.utils.spring.SpringContextUtils;
import com.cofire.dao.mapper.system.LoginAuditsMapper;
import com.cofire.dao.mapper.system.OperateAuditsMapper;
import com.cofire.dao.model.system.LoginAudits;
import com.cofire.dao.model.system.OperateAudits;

/**
 * 
 * @ClassName: LogTaskFactory
 * @Description:日志操作任务创建工厂
 * @date 2019年4月30日
 *
 */
@DependsOn("springContextUtils")
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogTaskFactory.class);
    private static OperateAuditsMapper operationLogMapper = SpringContextUtils.getBean(OperateAuditsMapper.class);
    private static LoginAuditsMapper loginAuditsMapper = SpringContextUtils.getBean(LoginAuditsMapper.class);

    public static TimerTask bussinessLog(String ip, String sessionId, String reqUrl, String userId, String description, String requestdPara) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    OperateAudits operateAudit = LogFactory.createOperateAudits(ip, sessionId, reqUrl, userId, description, requestdPara);
                    operationLogMapper.insert(operateAudit);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String ip, final String sessionId, final String auditType, final String userId, final String sourceType) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginAudits loginAudits = LogFactory.createLoginAudits(ip, sessionId, auditType, userId, sourceType);
                    loginAuditsMapper.insert(loginAudits);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(OperateAudits operateAudit) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    operationLogMapper.insert(operateAudit);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }
}
