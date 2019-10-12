package com.cofire.dao.model.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDetailModel<T> {
    private String UserId;
    private String UserName;
    private String LastIp;
    private String LastDate;
    private List<T> menuList = new ArrayList<T>();
    private HashMap common;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getLastIp() {
        return LastIp;
    }

    public void setLastIp(String lastIp) {
        LastIp = lastIp;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String lastDate) {
        LastDate = lastDate;
    }

    public List<T> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<T> menuList) {
        this.menuList = menuList;
    }

    public HashMap getCommon() {
        return common;
    }

    public void setCommon(HashMap common) {
        this.common = common;
    }

}
