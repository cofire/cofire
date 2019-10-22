package com.cofire.dao.model.custom;

import java.util.ArrayList;
import java.util.List;

public class UserDetailModel<T, V> {
    private T user;
    private List<V> menuList = new ArrayList<V>();
    private Object dictList;

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public List<V> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<V> menuList) {
        this.menuList = menuList;
    }

    public Object getDictList() {
        return dictList;
    }

    public void setDictList(Object dictList) {
        this.dictList = dictList;
    }

}
