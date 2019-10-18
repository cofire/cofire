package com.cofire.console.service.sytem;

import java.util.List;
import java.util.Map;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysUser;

public interface IUserService {
    List<Map<String, String>> getUserResource(String userId);

    Result query(ParamItem paramItem, SysUser user);

    Result add(SysUser user);

    Result upadte(SysUser user);

    Result delete(String userId);

    Result saveUserRole(String userId, String roleIds);

    Result restPassWord(String userId);

    Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord);
}
