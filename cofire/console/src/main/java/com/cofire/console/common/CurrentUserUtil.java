package com.cofire.console.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.cofire.common.constant.Constants;
import com.cofire.dao.model.system.SysUser;

/**
 * @author ly
 * @version V1.0
 * @ClassName: CurrentUserUtil
 * @Description:获取当前用户的工具类
 * @date 2019年12月4日
 */
public class CurrentUserUtil {
    /**
     * @param @return 参数
     * @return SysUser 返回类型
     * @Title: getCurentUser
     * @author ly
     * @Description:获取当前用户
     */
    public static SysUser getCurrentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
        if (user == null) {
            return new SysUser();
        }
        return user;
    }

    /**
     * @param @return 参数
     * @return String 返回类型
     * @Title: getCurentUserId
     * @author ly
     * @Description:获取当前用户id
     */
    public static String getCurrentUserId() {
        return getCurrentUser().getUserId();
    }
}
