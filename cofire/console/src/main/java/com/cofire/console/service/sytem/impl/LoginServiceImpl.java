package com.cofire.console.service.sytem.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.Result;
import com.cofire.common.utils.context.HttpContext;
import com.cofire.common.utils.security.DESCrypto;
import com.cofire.common.utils.security.MD5Crypto;
import com.cofire.console.config.log.LogManager;
import com.cofire.console.config.log.factory.LogTaskFactory;
import com.cofire.console.service.sytem.ILoginService;
import com.cofire.dao.model.system.SysUser;

@Service
public class LoginServiceImpl implements ILoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public Result authLogin(String userId, String passWord, String sourceType, String operation) {
        Result result = new Result();
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(passWord)) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        // 密码3des解密
        passWord = DESCrypto.JS3DESEncryption(userId, passWord);
        // // 明文密码MD5加密
        try {
            passWord = MD5Crypto.encrypt(passWord, userId);
        } catch (Exception e) {
            logger.error("用户密码加密失败：" + e.getMessage());
            result = new Result(CodeEnum.E_400);
            return result;
        }

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userId, passWord);
        try {
            currentUser.login(token);
            logger.info("登录成功！");
        } catch (AuthenticationException e) {
            logger.error("用户密码加密失败：" + e.getMessage());
            result = new Result(CodeEnum.E_400);
            return result;
        }
        try {
            String ip = HttpContext.getClientIP();
            Session session = SecurityUtils.getSubject().getSession();
            String sesionId = (String) session.getId();
            LogManager.me().executeLog(LogTaskFactory.loginLog(ip, sesionId, Constants.AUDIT_TYPE_LOGIN, userId, sourceType));

        } catch (Exception e) {
            logger.error("记录登录日志失败：" + e.getMessage());
        }
        result = new Result(true, CodeEnum.E_200);
        return result;
    }

    @Override
    public Result logout(String sourceType, String operation) {
        Result result = new Result();
        try {
            Session session = SecurityUtils.getSubject().getSession();
            SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
            // 用户为空时，不记日志
            if (null != user && StringUtils.isNotEmpty(user.getUserId())) {

                String userId = user.getUserId();
                String sesionId = (String) session.getId();
                String ip = HttpContext.getClientIP();
                LogManager.me().executeLog(LogTaskFactory.loginLog(ip, sesionId, Constants.AUDIT_TYPE_LOGIN_OUT, userId, sourceType));
            }
        } catch (Exception e) {
            logger.error("记录登录日志失败：" + e.getMessage());
        }

        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("退出登录失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

}
