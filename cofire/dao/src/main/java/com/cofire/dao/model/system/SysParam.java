package com.cofire.dao.model.system;

import java.io.Serializable;

/**
 * @数表名称 sys_param
 * @开发日期 2019-12-20
 * @开发作者 by:ly
 */
public class SysParam implements Serializable {
    /**
     * 组号 (主健ID)(必填项) (无默认值)
     */
    private String groupId;

    /**
     * 参数id(必填项) (主健ID) (无默认值)
     */
    private String paramId;

    /**
     * 参数值(必填项)(必填项) (无默认值)
     */
    private String paramValue;

    /**
     * 参数名(必填项)(必填项) (无默认值)
     */
    private String paramName;

    /**
     * 是否可修改(必填项)(必填项) (无默认值)
     */
    private String canDelete;

    /**
     * 备注 (无默认值)
     */
    private String remark;

    /**
     * 最后修改人 (无默认值)
     */
    private String modifier;

    /**
     * 最后修改时间 (无默认值)
     */
    private String modifyTime;

    /**
     * 预留字段1 (无默认值)
     */
    private String filler1;

    /**
     * 预留字段2 (无默认值)
     */
    private String filler2;

    /**
     * 预留字段3 (无默认值)
     */
    private String filler3;

    /**
     * 预留字段4 (无默认值)
     */
    private String filler4;

    private static final long serialVersionUID = 1L;

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

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete == null ? null : canDelete.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
