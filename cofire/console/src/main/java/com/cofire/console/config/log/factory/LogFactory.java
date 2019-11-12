package com.cofire.console.config.log.factory;

import java.util.Date;

import com.cofire.common.utils.string.DateUtils;
import com.cofire.dao.model.system.SysLoginAudit;
import com.cofire.dao.model.system.SysOperateAudit;

public class LogFactory {

    /**
     * 
     * @Title: OperateAudits
     * @Description:创建操作日志
     * @return
     * @return OperateAudits 返回类型
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
        if (description.length() > 1000) {
            description = description.substring(0, 1000);
        }
        operateAudit.setDescription(description);
        if (parameter == null) {
            parameter = "";
        }
        if (parameter.length() > 400) {
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
