package com.cofire.dao.model.system;

import java.io.Serializable;

/**
 * @数表名称 sys_resource
 * @开发日期 2019-12-20
 * @开发作者 by:ly
 */
public class SysResource implements Serializable {
    /**
     * 菜单id (主健ID) (无默认值)
     */
    private String resourceId;

    /**
     * 菜单名称(必填项) (无默认值)
     */
    private String resourceName;

    /**
     * 菜单链接 (无默认值)
     */
    private String url;

    /**
     * 父节点id (无默认值)
     */
    private String parentResourceId;

    /**
     * 是否叶节点(必填项) (无默认值)
     */
    private String isLeaf;

    /**
     * 排序 (无默认值)
     */
    private Integer morder;

    /**
     * 是否可用(必填项) (无默认值)
     */
    private String enabled;

    /**
     * 最后修改人 (无默认值)
     */
    private String modifier;

    /**
     * 最后修改时间 (无默认值)
     */
    private String modifyTime;

    /**
     * 小图标 (无默认值)
     */
    private String icon;

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

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentResourceId() {
        return parentResourceId;
    }

    public void setParentResourceId(String parentResourceId) {
        this.parentResourceId = parentResourceId == null ? null : parentResourceId.trim();
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
