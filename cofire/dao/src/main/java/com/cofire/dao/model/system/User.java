package com.cofire.dao.model.system;

/**
 * @数表名称 sys_user
 * @开发日期 2019-09-04
 * @开发作者 by:ly 
 */
public class User {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** 用户名-即用户登录时使用的名称(必填项) (无默认值) */
    private String userId;

    /** 用户昵称，或者真实名称 (无默认值) */
    private String userName;

    /** 密码 (无默认值) */
    private String passWord;

    /** 英文名称 (无默认值) */
    private String enName;

    /** 中文名称 (无默认值) */
    private String cnName;

    /** 上次登录ip (无默认值) */
    private String lastIp;

    /** 上次登录时间 (无默认值) */
    private String lastDate;

    /** 密码连续错误次数 (无默认值) */
    private Integer wrongPwdCount;

    /** 创建人 (无默认值) */
    private String creator;

    /** 创建时间 (无默认值) */
    private String createTime;

    /** 用户状态 "00-未登录
01-已登录
02-已冻结
03-已过期04-已注销" (无默认值) */
    private String status;

    /** 审核状态0-未审核;1-已审核;2-审核拒绝 (无默认值) */
    private String checkStatus;

    /** 审核人 (无默认值) */
    private String checker;

    /** 审核时间,格式yyyymmddhh24miss (无默认值) */
    private String checkTime;

    /** 修改密码标志 0-不需要；1-需要 (无默认值) */
    private String changePwdFlag;

    /** 预留字段1 (无默认值) */
    private String filler1;

    /** 预留字段2 (无默认值) */
    private String filler2;

    /** 预留字段3 (无默认值) */
    private String filler3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate == null ? null : lastDate.trim();
    }

    public Integer getWrongPwdCount() {
        return wrongPwdCount;
    }

    public void setWrongPwdCount(Integer wrongPwdCount) {
        this.wrongPwdCount = wrongPwdCount;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
    }

    public String getChangePwdFlag() {
        return changePwdFlag;
    }

    public void setChangePwdFlag(String changePwdFlag) {
        this.changePwdFlag = changePwdFlag == null ? null : changePwdFlag.trim();
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