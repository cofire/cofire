package com.cofire.console.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.cofire.common.constant.Constants;
import com.cofire.dao.model.system.SysUser;

/**
 * 
 * @ClassName: CurrentUserUtil
 * @Description:获取当前用户的工具类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class CurrentUserUtil {
    /**
     * 
     * @Title: getCurentUser
     * @author ly
     * @Description:获取当前用户
     * @param @return 参数
     * @return SysUser 返回类型
     */
    public static SysUser getCurentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
        if (user == null) {
            return new SysUser();
        }
        return user;
    }

    /**
     * 
     * @Title: getCurentUserId
     * @author ly
     * @Description:获取当前用户id
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getCurentUserId() {
        return getCurentUser().getUserId();
    }
}
