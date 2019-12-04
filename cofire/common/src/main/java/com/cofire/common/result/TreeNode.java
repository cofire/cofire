package com.cofire.common.result;

import java.util.List;

/**
 * 
 * @ClassName: TreeNode
 * @Description:树结构
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class TreeNode {
    /** 本节点id */
    private String id;
    /** 本节点名称 */
    private String name;
    /** 本节点的父节点 */
    private String parentId;
    /** 子节点 */
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(String id, String name, String parentId) {
        this();
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}