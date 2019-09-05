package com.cofire.dao.model.system;

/**
 * @数表名称 sys_resource
 * @开发日期 2019-09-04
 * @开发作者 by:ly 
 */
public class Resource {
    /** 资源id (主健ID) (无默认值) */
    private String resourceId;

    /** 资源中文名称(必填项) (无默认值) */
    private String cnDescription;

    /** 资源英文名称 (无默认值) */
    private String enDescription;

    /** 资源链接 (无默认值) */
    private String url;

    /** 父节点id (无默认值) */
    private String parentId;

    /** 是否叶节点(必填项) (无默认值) */
    private String isLeaf;

    /** 排序 (无默认值) */
    private Integer morder;

    /** 是否可用(必填项) (无默认值) */
    private String enabled;

    /** 创建人 (无默认值) */
    private String creator;

    /** 创建时间 (无默认值) */
    private String createTime;

    /** 是否是按钮 (无默认值) */
    private String isButton;

    /** 按钮id (无默认值) */
    private String buttonId;

    /** 小图标 (无默认值) */
    private String icon;

    /** 预留字段1 (无默认值) */
    private String filler1;

    /** 预留字段2 (无默认值) */
    private String filler2;

    /** 预留字段3 (无默认值) */
    private String filler3;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getCnDescription() {
        return cnDescription;
    }

    public void setCnDescription(String cnDescription) {
        this.cnDescription = cnDescription == null ? null : cnDescription.trim();
    }

    public String getEnDescription() {
        return enDescription;
    }

    public void setEnDescription(String enDescription) {
        this.enDescription = enDescription == null ? null : enDescription.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    public Integer getMorder() {
        return morder;
    }

    public void setMorder(Integer morder) {
        this.morder = morder;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
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

    public String getIsButton() {
        return isButton;
    }

    public void setIsButton(String isButton) {
        this.isButton = isButton == null ? null : isButton.trim();
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId == null ? null : buttonId.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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