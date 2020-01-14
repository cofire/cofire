package com.cofire.shiro.service;

import java.util.Set;

import com.cofire.dao.model.system.SysUser;

public interface IUserPermissionService {
    SysUser getUserByIdAndPwd(String id, String password);

    Set<String> getUserPermission(String userId);
}
