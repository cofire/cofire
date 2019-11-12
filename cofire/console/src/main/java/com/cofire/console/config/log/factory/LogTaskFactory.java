package com.cofire.console.config.log.factory;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;

import com.cofire.common.utils.spring.SpringContextUtils;
import com.cofire.dao.mapper.system.SysLoginAuditMapper;
import com.cofire.dao.mapper.system.SysOperateAuditMapper;
import com.cofire.dao.model.system.SysLoginAudit;
import com.cofire.dao.model.system.SysOperateAudit;

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
    private static SysOperateAuditMapper operationLogMapper = SpringContextUtils.getBean(SysOperateAuditMapper.class);
    private static SysLoginAuditMapper loginAuditsMapper = SpringContextUtils.getBean(SysLoginAuditMapper.class);

    public static TimerTask bussinessLog(String ip, String sessionId, String reqUrl, String userId, String description, String parameter, String sourceType,
            String operationType) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    SysOperateAudit operateAudit = LogFactory.createOperateAudit(ip, sessionId, reqUrl, userId, description, parameter, sourceType,
                            operationType);
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
                    SysLoginAudit loginAudits = LogFactory.createLoginAudit(ip, sessionId, auditType, userId, sourceType);
                    loginAuditsMapper.insert(loginAudits);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(SysOperateAudit operateAudit) {
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
