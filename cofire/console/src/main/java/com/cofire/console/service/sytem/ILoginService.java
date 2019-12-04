package com.cofire.console.service.sytem;

import com.cofire.common.result.Result;

/**
 * 
 * @ClassName: ILoginService
 * @Description:登录登出
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public interface ILoginService {
    /**
     * 登录表单提交
     * 
     * @param userId
     * @param passWord
     * @param sourceType
     * @param operation
     * @return
     */
    Result authLogin(String userId, String passWord, String sourceType, String operation);

    /**
     * 退出登录
     * 
     * @param sourceType
     * @param operation
     * @return
     */
    Result logout(String sourceType, String operation);

}
