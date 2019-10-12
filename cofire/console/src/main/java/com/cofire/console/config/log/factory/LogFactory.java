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
    public static SysOperateAudit createOperateAudit(String ip, String sessionId, String reqUrl, String userId, String description, String requestdPara)
            throws Exception {
        SysOperateAudit operateAudits = new SysOperateAudit();
        operateAudits.setIp(ip);
        operateAudits.setSessionId(sessionId);
        operateAudits.setRequestUrl(reqUrl);
        operateAudits.setUserId(userId);
        if (description == null) {
            description = "";
        }
        if (description.length() > 1000) {
            description = description.substring(0, 1000);
        }
        operateAudits.setDescription(description);
        if (requestdPara == null) {
            requestdPara = "";
        }
        if (requestdPara.length() > 400) {
            requestdPara = requestdPara.substring(0, 400);
        }
        operateAudits.setRequestParam(requestdPara);
        operateAudits.setRequestTime(DateUtils.dataTimeToNumber(new Date()));
        operateAudits.setFiller1("");
        operateAudits.setFiller2("");
        operateAudits.setFiller3("");
        return operateAudits;
    }

    public static SysLoginAudit createLoginAudit(String ip, String sessionId, String auditType, String userId, String sourceType) throws Exception {
        SysLoginAudit loginAudits = new SysLoginAudit();
        loginAudits.setIp(ip);
        loginAudits.setSessionId(sessionId);
        loginAudits.setCreateTime(DateUtils.dataTimeToNumber(new Date()));
        loginAudits.setAuditType(auditType);
        loginAudits.setUserId(userId);
        loginAudits.setFiller1("");
        loginAudits.setFiller2("");
        loginAudits.setFiller3("");
        loginAudits.setSourceType(sourceType);
        loginAudits.setMessage("");
        return loginAudits;
    }
}
