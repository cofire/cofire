package com.cofire.dao.model.custom;

public class Menu {
    private String data;
    private String text;
    private String link;
    private String icon;
    private Object submenu;
    private boolean heading; // 导航

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Object submenu) {
        this.submenu = submenu;
    }

    public boolean isHeading() {
        return heading;
    }

    public void setHeading(boolean heading) {
        this.heading = heading;
    }
}