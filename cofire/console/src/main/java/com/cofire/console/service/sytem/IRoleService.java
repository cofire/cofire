package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysRole;
import com.cofire.dao.model.system.SysUser;

public interface IRoleService {

    Result query(ParamItem paramItem, SysRole role);

    Result add(SysRole role, String permission);

    Result upadte(SysRole role, String permission);

    Result delete(SysRole role);

    Result queryUserRoleList(SysUser user);

    Result getRoleTree(String roleId);
}
