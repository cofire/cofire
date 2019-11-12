package com.cofire.console.service.sytem;

import com.cofire.common.result.Result;

public interface ILoginService {
    /**
     * 登录表单提交
     */
    Result authLogin(String userId, String passWord, String sourceType, String operation);

    /**
     * 退出登录
     */
    Result logout(String sourceType, String operation);

}
