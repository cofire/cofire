package com.cofire.dao.model.system;

/**
 * @数表名称 sys_login_audit
 * @开发日期 2019-09-04
 * @开发作者 by:ly 
 */
public class LoginAudits {
    /** 编号 (主健ID) (无默认值) */
    private Long sid;

    /** ip地址 (无默认值) */
    private String ip;

    /** 会话id (无默认值) */
    private String sessionId;

    /** 创建时间 (无默认值) */
    private String createTime;

    /** 审计类型:0-登录；1-登出 (无默认值) */
    private String auditType;

    /** 用户登录id (无默认值) */
    private String userId;

    /** 来源类型 (无默认值) */
    private String sourceType;

    /** 预留字段1 (无默认值) */
    private String filler1;

    /** 预留字段2 (无默认值) */
    private String filler2;

    /** 预留字段3 (无默认值) */
    private String filler3;

    /** 消息 (无默认值) */
    private String message;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType == null ? null : auditType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getFiller1() {
        return filler1;
    }

    public void setFiller1(String filler1) {
        this.filler1 = filler1 == null ? null : filler1.trim();
    }

    public String getFiller2() {
        return filler2;
    }

    public void setFiller2(String filler2) {
        this.filler2 = filler2 == null ? null : filler2.trim();
    }

    public String getFiller3() {
        return filler3;
    }

    public void setFiller3(String filler3) {
        this.filler3 = filler3 == null ? null : filler3.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}