package com.cofire.shiro.config;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cofire.common.utils.constant.Constants;
import com.cofire.dao.model.system.User;
import com.cofire.shiro.service.IUserPermissionService;

public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private IUserPermissionService userPermissionService;

    @Override
    @SuppressWarnings("unchecked")
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Session session = SecurityUtils.getSubject().getSession();
        // 查询用户的权限
        Collection<String> permission = (Collection<String>) session.getAttribute(Constants.SESSION_USER_PERMISSION);
        logger.info("permission的值为:" + permission);
        // 为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permission);
        return authorizationInfo;
    }

    /**
     * 验证当前登录的Subject LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String userId = (String) authcToken.getPrincipal();
        // 获取用户密码
        String password = new String((char[]) authcToken.getCredentials());
        User user = userPermissionService.getUserByIdAndPwd(userId, password);
        if (user == null) {
            // 没找到帐号
            throw new UnknownAccountException();
        }
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserId(), user.getPassWord(),
                // ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
                getName());
        // session中不需要保存密码
        user.setPassWord("");
        // 将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
        SecurityUtils.getSubject().getSession().setTimeout(900000L);
        Set<String> userPermission = userPermissionService.getUserPermission(userId);
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        return authenticationInfo;
    }
}
