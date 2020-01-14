package com.cofire.console.config.log.factory;

import java.util.Date;

import com.cofire.common.utils.string.DateUtils;
import com.cofire.dao.model.system.SysLoginAudit;
import com.cofire.dao.model.system.SysOperateAudit;

/**
 * @author ly
 * @version V1.0
 * @ClassName: LogFactory
 * @Description:日志工厂
 * @date 2019年12月4日
 */
public class LogFactory {
    private static final int DESCRIPTION_LENGTH = 1000;
    private static final int PARAMETER_LENGTH = 1000;

    /**
     * @param @param  ip
     * @param @param  sessionId
     * @param @param  reqUrl
     * @param @param  userId
     * @param @param  description
     * @param @param  parameter
     * @param @param  sourceType
     * @param @param  operationType
     * @param @return
     * @param @throws Exception 参数
     * @return SysOperateAudit 返回类型
     * @Title: createOperateAudit
     * @author ly
     * @Description:创建操作日志
     */
    public static SysOperateAudit createOperateAudit(String ip, String sessionId, String reqUrl, String userId, String description, String parameter,
                                                     String sourceType, String operationType) throws Exception {
        SysOperateAudit operateAudit = new SysOperateAudit();
        operateAudit.setIp(ip);
        operateAudit.setSessionId(sessionId);
        operateAudit.setRequestUrl(reqUrl);
        operateAudit.setUserId(userId);
        if (description == null) {
            description = "";
        }
        if (description.length() > DESCRIPTION_LENGTH) {
            description = description.substring(0, 1000);
        }
        operateAudit.setDescription(description);
        if (parameter == null) {
            parameter = "";
        }
        if (parameter.length() > PARAMETER_LENGTH) {
            parameter = parameter.substring(0, 400);
        }
        operateAudit.setRequestParam(parameter);
        operateAudit.setRequestTime(DateUtils.dataTimeToNumber(new Date()));
        operateAudit.setOperationType(operationType);
        operateAudit.setSourceType(sourceType);
        operateAudit.setFiller1("");
        operateAudit.setFiller2("");
        operateAudit.setFiller3("");
        return operateAudit;
    }

    public static SysLoginAudit createLoginAudit(String ip, String sessionId, String auditType, String userId, String sourceType) throws Exception {
        SysLoginAudit loginAudit = new SysLoginAudit();
        loginAudit.setIp(ip);
        loginAudit.setSessionId(sessionId);
        loginAudit.setCreateTime(DateUtils.dataTimeToNumber(new Date()));
        loginAudit.setAuditType(auditType);
        loginAudit.setSourceType(sourceType);
        loginAudit.setUserId(userId);
        loginAudit.setFiller1("");
        loginAudit.setFiller2("");
        loginAudit.setFiller3("");

        loginAudit.setMessage("");
        return loginAudit;
    }
}
