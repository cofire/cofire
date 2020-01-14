package com.cofire.shiro.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.dao.mapper.custom.UserPermissionCustomMapper;
import com.cofire.dao.mapper.system.SysUserMapper;
import com.cofire.dao.model.system.SysUser;
import com.cofire.dao.model.system.SysUserExample;
import com.cofire.shiro.service.IUserPermissionService;

@Service
public class UserPermissionServiceImpl implements IUserPermissionService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private UserPermissionCustomMapper userPermissionCustomMapper;

    /**
     * 验证用户的账户密码
     */
    @Override
    public SysUser getUserByIdAndPwd(String id, String password) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        criteria.andPassWordEqualTo(password);
        List<SysUser> m_userList = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(m_userList)) {
            return m_userList.get(0);
        }
        return null;
    }

    /**
     * @return Set<String> 返回类型
     * @Title: getUserPermission
     * @Description:获取用户权限
     */
    @Override
    public Set<String> getUserPermission(String userId) {
        Set<String> userPermission = userPermissionCustomMapper.getUserPermission(userId);
        userPermission.remove(null);
        userPermission.remove("");
        return userPermission;
    }
}
