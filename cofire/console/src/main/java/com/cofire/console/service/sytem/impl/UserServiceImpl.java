package com.cofire.console.service.sytem.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.mapper.custom.UserPermissionCustomMapper;

@Service
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserPermissionCustomMapper userPermissionCustomMapper;

    /**
     * 获取用户权限
     */
    @Override
    public List<Map<String, String>> getUserResource(String userId) {
        List<Map<String, String>> userResourceList = userPermissionCustomMapper.getUserResource(userId);
        return userResourceList;
    }
}
