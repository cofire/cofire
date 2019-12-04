package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysRole;
import com.cofire.dao.model.system.SysUser;

/**
 * 
 * @ClassName: IRoleService
 * @Description:角色信息
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public interface IRoleService {
    /**
     * 角色信息查询
     * 
     * @param paramItem
     * @param role
     * @return
     */
    Result query(ParamItem paramItem, SysRole role);

    /**
     * 角色信息新增
     * 
     * @param role
     * @param permission
     * @return
     */
    Result add(SysRole role, String permission);

    /**
     * 角色信息修改
     * 
     * @param role
     * @param permission
     * @return
     */
    Result update(SysRole role, String permission);

    /**
     * 角色信息删除
     * 
     * @param role
     * @return
     */
    Result delete(SysRole role);

    /**
     * 查询用户角色
     * 
     * @param user
     * @return
     */
    Result queryUserRoleList(SysUser user);

    /**
     * 或者角色权限树
     * 
     * @param roleId
     * @return
     */
    Result getRoleTree(String roleId);
}
