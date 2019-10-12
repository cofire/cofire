package com.cofire.console.service.sytem;

import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysUser;

public interface ILoginService {
    /**
     * 登录表单提交
     */
    Result authLogin(SysUser user);

    /**
     * 退出登录
     */
    Result logout();
}
