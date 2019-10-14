package com.cofire.dao.model.system;

import java.io.Serializable;

/**
 * @数表名称 qtz_job
 * @开发日期 2019-10-14
 * @开发作者 by:ly 
 */
public class QtzJob implements Serializable {
    /** 定时任务id (主健ID) (无默认值) */
    private String jobId;

    /** 任务名称(必填项) (无默认值) */
    private String jobName;

    /** 任务描述 (无默认值) */
    private String jobDesc;

    /** 年(必填项) (无默认值) */
    private String year;

    /** 月(必填项) (无默认值) */
    private String month;

    /** 日期(必填项) (无默认值) */
    private String date;

    /** 星期(必填项) (无默认值) */
    private String day;

    /** 小时(必填项) (无默认值) */
    private String hour;

    /** 分(必填项) (无默认值) */
    private String minute;

    /** 秒(必填项) (无默认值) */
    private String second;

    /** 生效日期 (无默认值) */
    private String activeDt;

    /** 失效日期 (无默认值) */
    private String expiryDt;

    /** 逻辑删除标识:0-未删除；1-已删除(必填项) (无默认值) */
    private String isDel;

    /** 最后修改人 (无默认值) */
    private String modifier;

    /** 最后修改时间 (无默认值) */
    private String modifyTime;

    /** 附加参数1 (无默认值) */
    private String param1;

    /** 附加参数2 (无默认值) */
    private String param2;

    /** 附加参数3 (无默认值) */
    private String param3;

    /** 附加参数4 (无默认值) */
    private String param4;

    /** 附加参数5 (无默认值) */
    private String param5;

    private static final long serialVersionUID = 1L;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc == null ? null : jobDesc.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute == null ? null : minute.trim();
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second == null ? null : second.trim();
    }

    public String getActiveDt() {
        return activeDt;
    }

    public void setActiveDt(String activeDt) {
        this.activeDt = activeDt == null ? null : activeDt.trim();
    }

    public String getExpiryDt() {
        return expiryDt;
    }

    public void setExpiryDt(String expiryDt) {
        this.expiryDt = expiryDt == null ? null : expiryDt.trim();
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3 == null ? null : param3.trim();
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4 == null ? null : param4.trim();
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5 == null ? null : param5.trim();
    }
}