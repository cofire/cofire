package com.cofire.dao.model.custom;

public class Menu {
    private String id;
    private String name;
    private String url;
    private String icon;
    private String parentId;
    private Object subMenu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Object subMenu) {
        this.subMenu = subMenu;
    }

}