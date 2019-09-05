package com.cofire.dao.model.system;

/**
 * @数表名称 qtz_job
 * @开发日期 2019-09-04
 * @开发作者 by:ly 
 */
public class Job {
    /** 序号 (主健ID) (无默认值) */
    private String id;

    /** 任务名称(必填项) (无默认值) */
    private String jobName;

    /** 任务描述 (无默认值) */
    private String jobDesc;

    /** 任务类型(必填项) (无默认值) */
    private String jobType;

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

    /** 逻辑删除标识(必填项) (无默认值) */
    private String del;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
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

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
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