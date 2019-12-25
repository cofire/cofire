package com.cofire.dao.model.system;

import java.io.Serializable;

/**
 * @数表名称 sys_user
 * @开发日期 2019-12-20
 * @开发作者 by:ly
 */
public class SysUser implements Serializable {
    /**
     * 用户账号 (主健ID) (无默认值)
     */
    private String userId;

    /**
     * 用户姓名 (无默认值)
     */
    private String userName;

    /**
     * 密码 (无默认值)
     */
    private String passWord;

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

    private static final long serialVersionUID = 1L;

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
}
