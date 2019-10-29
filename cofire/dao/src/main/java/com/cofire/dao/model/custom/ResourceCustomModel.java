package com.cofire.dao.model.custom;

import java.util.List;

import com.cofire.dao.model.system.SysResource;

public class ResourceCustomModel extends SysResource {

    private static final long serialVersionUID = 1L;
    /* 子菜单 */
    private List<ResourceCustomModel> children;

    public List<ResourceCustomModel> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceCustomModel> children) {
        this.children = children;
    }

}
