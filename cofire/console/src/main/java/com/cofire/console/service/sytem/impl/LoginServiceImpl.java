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
    public Result authLogin(SysUser user) {
        Result result = new Result();
        if (user == null || StringUtils.isEmpty(user.getUserId()) || StringUtils.isEmpty(user.getPassWord())) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        String userId = user.getUserId();
        String password = user.getPassWord();
        // 密码3des解密
        password = DESCrypto.JS3DESEncryption(userId, password);
        // // 明文密码MD5加密
        try {
            password = MD5Crypto.encrypt(userId, password);
            user.setPassWord(password);
        } catch (Exception e) {
            logger.error("用户密码加密失败：" + e.getMessage());
            result = new Result(CodeEnum.E_400);
            return result;
        }

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserId(), user.getPassWord());
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
            LogManager.me().executeLog(LogTaskFactory.loginLog(ip, sesionId, Constants.AUDIT_TYPE_LOGIN, userId, Constants.SOURCE_TYPE_PC));

        } catch (Exception e) {
            logger.error("记录登录日志失败：" + e.getMessage());
        }
        result = new Result(true, CodeEnum.E_200);
        return result;
    }

    @Override
    public Result logout() {
        Result result = new Result();
        String url = HttpContext.getRequestURI();
        // 获取url中参数 ，PC端第二个为console,pad端第二个为ipad
        String padOrPc = url.split("/")[1];
        System.out.println(padOrPc + "打印url");
        try {
            Session session = SecurityUtils.getSubject().getSession();
            SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
            // 用户为空时，不记日志
            if (null != user && StringUtils.isNotEmpty(user.getUserId())) {

                String userId = user.getUserId();
                String sesionId = (String) session.getId();
                String ip = HttpContext.getClientIP();
                LogManager.me().executeLog(LogTaskFactory.loginLog(ip, sesionId, Constants.AUDIT_TYPE_LOGIN_OUT, userId, Constants.AUDIT_TYPE_LOGIN));
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
