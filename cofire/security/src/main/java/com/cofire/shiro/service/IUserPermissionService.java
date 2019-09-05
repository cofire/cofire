package com.cofire.shiro.service;

import java.util.Set;

import com.cofire.dao.model.system.User;

public interface IUserPermissionService {
    User getUserByIdAndPwd(String id, String password);

    Set<String> getUserPermission(String p_userId);
}
