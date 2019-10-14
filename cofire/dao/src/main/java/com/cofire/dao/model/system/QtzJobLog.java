package com.cofire.dao.model.system;

import java.io.Serializable;

/**
 * @数表名称 qtz_job_log
 * @开发日期 2019-10-14
 * @开发作者 by:ly 
 */
public class QtzJobLog implements Serializable {
    /** 自增id (主健ID) (无默认值) */
    private Long sid;

    /** 定时任务id (无默认值) */
    private String jobId;

    /** 执行时间 (无默认值) */
    private String runTime;

    /** 运行时ip (无默认值) */
    private String ip;

    /** 是否成功 (无默认值) */
    private String isSuccess;

    /** 信息 (无默认值) */
    private String message;

    /** 预留字段1 (无默认值) */
    private String filler1;

    /** 预留字段2 (无默认值) */
    private String filler2;

    /** 预留字段3 (无默认值) */
    private String filler3;

    private static final long serialVersionUID = 1L;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime == null ? null : runTime.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess == null ? null : isSuccess.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
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
}