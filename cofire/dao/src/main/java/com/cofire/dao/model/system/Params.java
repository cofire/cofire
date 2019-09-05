package com.cofire.dao.model.system;

/**
 * @数表名称 sys_params
 * @开发日期 2019-09-04
 * @开发作者 by:ly 
 */
public class Params {
    /** 段号 (主健ID)(必填项) (无默认值) */
    private String groupId;

    /** 参数id(必填项) (主健ID) (无默认值) */
    private String paramId;

    /** 参数值(必填项)(必填项) (无默认值) */
    private String paramVal;

    /** 参数名(必填项)(必填项) (无默认值) */
    private String paramName;

    /** 是否可修改(必填项)(必填项) (无默认值) */
    private String ifCanmodify;

    /** 备注 (无默认值) */
    private String remark;

    /** 最后修改人 (无默认值) */
    private String modifyUser;

    /** 最后修改时间 (无默认值) */
    private String modifyTime;

    /**  (无默认值) */
    private String checkTlrno;

    /**  (无默认值) */
    private String checkTime;

    /** 预留字段1 (无默认值) */
    private String filler1;

    /** 预留字段2 (无默认值) */
    private String filler2;

    /** 预留字段3 (无默认值) */
    private String filler3;

    /** 预留字段4 (无默认值) */
    private String filler4;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId == null ? null : paramId.trim();
    }

    public String getParamVal() {
        return paramVal;
    }

    public void setParamVal(String paramVal) {
        this.paramVal = paramVal == null ? null : paramVal.trim();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getIfCanmodify() {
        return ifCanmodify;
    }

    public void setIfCanmodify(String ifCanmodify) {
        this.ifCanmodify = ifCanmodify == null ? null : ifCanmodify.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    public String getCheckTlrno() {
        return checkTlrno;
    }

    public void setCheckTlrno(String checkTlrno) {
        this.checkTlrno = checkTlrno == null ? null : checkTlrno.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime == null ? null : checkTime.trim();
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

    public String getFiller4() {
        return filler4;
    }

    public void setFiller4(String filler4) {
        this.filler4 = filler4 == null ? null : filler4.trim();
    }
}