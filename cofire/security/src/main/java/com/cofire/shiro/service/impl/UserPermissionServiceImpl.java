package com.cofire.shiro.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.dao.mapper.custom.UserPermissionCustomMapper;
import com.cofire.dao.mapper.system.UserMapper;
import com.cofire.dao.model.system.User;
import com.cofire.dao.model.system.UserExample;
import com.cofire.shiro.service.IUserPermissionService;

@Service
public class UserPermissionServiceImpl implements IUserPermissionService {

    @Autowired
    private UserMapper c_userMapper;
    @Autowired
    private UserPermissionCustomMapper c_userPermissionCustomMapper;

    /**
     * 验证用户的账户密码
     */
    @Override
    public User getUserByIdAndPwd(String p_id, String p_password) {
        UserExample m_example = new UserExample();
        UserExample.Criteria m_criteria = m_example.createCriteria();
        m_criteria.andUserIdEqualTo(p_id);
        m_criteria.andPassWordEqualTo(p_password);
        List<User> m_userList = c_userMapper.selectByExample(m_example);
        if (!CollectionUtils.isEmpty(m_userList)) {
            return m_userList.get(0);
        }
        return null;
    }

    /**
     * 
     * @Title: getUserPermission
     * @Description:获取用户权限
     * @return
     * @return Set<String> 返回类型
     */
    @Override
    public Set<String> getUserPermission(String p_userId) {
        Set<String> userPermission = c_userPermissionCustomMapper.getUserPermission(p_userId);
        userPermission.remove(null);
        userPermission.remove("");
        return userPermission;
    }
}
