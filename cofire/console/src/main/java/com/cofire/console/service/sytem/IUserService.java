package com.cofire.console.service.sytem;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysUser;

/**
 * 
 * @ClassName: IUserService
 * @Description:用户信息
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public interface IUserService {
    /**
     * 用户菜单
     * 
     * @param userId
     * @return
     */
    List<Map<String, String>> getUserResource(String userId);

    /**
     * 用户信息查询
     * 
     * @param paramItem
     * @param user
     * @return
     */
    Result query(ParamItem paramItem, SysUser user);

    /**
     * 用户信息新增
     * 
     * @param user
     * @return
     */
    Result add(SysUser user);

    /**
     * 用户信息修改
     * 
     * @param user
     * @return
     */
    Result update(SysUser user);

    /**
     * 用户信息删除
     * 
     * @param userId
     * @return
     */
    Result delete(String userId);

    /**
     * 用户信息保存角色信息
     * 
     * @param userId
     * @param roleIds
     * @return
     */
    Result saveUserRole(String userId, String roleIds);

    /**
     * 重置密码
     * 
     * @param userId
     * @return
     */
    Result restPassWord(String userId);

    /**
     * 修改密码
     * 
     * @param currentPassWord
     * @param newPassWord
     * @param confirmNewPassWord
     * @return
     */
    Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord);

    /**
     * 导出
     * 
     * @param user
     * @param response
     */
    void exportExcel(SysUser user, HttpServletResponse response);
}
