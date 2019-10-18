package com.cofire.console.service.sytem.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.common.utils.security.DESCrypto;
import com.cofire.common.utils.security.MD5Crypto;
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.string.DateUtils;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.mapper.custom.UserPermissionCustomMapper;
import com.cofire.dao.mapper.system.SysUserMapper;
import com.cofire.dao.mapper.system.SysUserRoleMapper;
import com.cofire.dao.model.system.SysUser;
import com.cofire.dao.model.system.SysUserExample;
import com.cofire.dao.model.system.SysUserRole;
import com.cofire.dao.model.system.SysUserRoleExample;

@Service
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserPermissionCustomMapper userPermissionCustomMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    /**
     * 获取用户权限
     */
    @Override
    public List<Map<String, String>> getUserResource(String userId) {
        List<Map<String, String>> userResourceList = userPermissionCustomMapper.getUserResource(userId);
        return userResourceList;
    }

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询用户信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysUser user) {
        logger.info("正在查询用户信息");
        Result result = new Result();
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        if (null != user) {
            logger.info("查询条件为" + user);
            if (StringUtils.isNotEmpty(user.getUserId())) {
                criteria.andUserIdLike("%" + user.getUserId() + "%");
            }
            if (StringUtils.isNotEmpty(user.getUserName())) {
                criteria.andUserNameLike("%" + user.getUserName() + "%");
            }
        }
        Long count = 0L;
        try {
            // 获取数据总和
            count = userMapper.countByExample(userExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                userExample.setDatabaseId(Constants.MYSQL);
                userExample.setOrderByClause("user_id DESC");
                userExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<SysUser> userList = null;
        try {
            // 获取数据集
            userList = userMapper.selectPageByExample(userExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询用户信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
        result.setData(userList);
        logger.info("查询用户信息完成");
        return result;
    }

    /**
     * 新增用户信息
     */
    @Override
    public Result add(SysUser user) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(user, "userId", "userNmae")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        List<SysUser> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            user.setModifyTime(Util.getCurrentDateTimeString());
            user.setPassWord(MD5Crypto.encrypt(user.getUserId(), user.getUserId()));
            user.setModifier(CurrentUserUtil.getCurentUserId());
            user.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
            userMapper.insert(user);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增用户信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: upadte
     * @author ly
     * @Description:用户信息
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result upadte(SysUser user) {
        Result result = new Result();
        try {
            logger.info("正在修改用户信息");
            SysUserExample userExample = new SysUserExample();
            SysUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andUserIdEqualTo(user.getUserId());
            user.setModifier(CurrentUserUtil.getCurentUserId());
            user.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
            userMapper.updateByExample(user, userExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改用户信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除用户信息
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(String userId) {
        logger.info("正在删除用户信息");
        Result result = new Result();
        try {
            logger.info("开始删除用户信息");
            // 根据主键删除对应记录
            SysUserExample userExample = new SysUserExample();
            SysUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andUserIdEqualTo(userId);
            userMapper.deleteByExample(userExample);
            SysUserRoleExample example = new SysUserRoleExample();
            SysUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            userRoleMapper.deleteByExample(example);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除用户信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }

    /**
     * 
     * @Title: saveUserRole
     * @author ly
     * @Description:保存用户角色信息
     * @param @param userId
     * @param @param roleIds
     * @param @return 参数
     * @return Result 返回类型
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result saveUserRole(String userId, String roleIds) {
        Result result = new Result();
        if (ParamValidator.checkParamsHasEmpty(userId)) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            SysUserRoleExample example = new SysUserRoleExample();
            SysUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            userRoleMapper.deleteByExample(example);
            if (StringUtils.isNotEmpty(roleIds)) {
                String[] roleIdArray = roleIds.split(",");
                HashSet<String> roleIdSet = new HashSet<>();
                CollectionUtils.addAll(roleIdSet, roleIdArray);
                for (String roleId : roleIdSet) {
                    SysUserRole userRole = new SysUserRole();
                    userRole.setRoleId(roleId);
                    userRole.setUserId(userId);
                    userRole.setModifier(CurrentUserUtil.getCurentUserId());
                    userRole.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
                    userRoleMapper.insertSelective(userRole);
                }
            }
            result.setSuccess(true, CodeEnum.E_700);
        } catch (Exception e) {
            logger.error("保存用户角色信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: restPassWord
     * @author ly
     * @Description:重置用户密码
     * @param @param userId
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result restPassWord(String userId) {
        logger.info("正在进行重置密码");
        Result result = new Result();
        if (ParamValidator.checkParamsHasEmpty(userId)) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            SysUser user = new SysUser();
            user.setUserId(userId);
            user.setPassWord(MD5Crypto.encrypt(userId, userId));
            userMapper.updateByPrimaryKeySelective(user);
            result.setSuccess(true, CodeEnum.E_700);
            result.setData(userId);
        } catch (Exception e) {
            logger.error("重置密码失败" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: changePassWord
     * @author ly
     * @Description:修改密码
     * @param @param currentPassWord
     * @param @param NewPassWord
     * @param @param confirmNewPassWord
     * @param @return 参数
     * @return Result 返回类型
     */
    /**
     * 
     * @Title: changePassWord
     * @author ly
     * @Description:修改密码
     * @param @param currentPassWord
     * @param @param newPassWord
     * @param @param confirmNewPassWord
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord) {
        logger.info("正在修改密码");
        Result result = new Result();
        if (ParamValidator.checkParamsHasEmpty(CurrentUserUtil.getCurentUserId(), currentPassWord, newPassWord, confirmNewPassWord)
                || !newPassWord.equals(confirmNewPassWord)) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            String oriPassWord = DESCrypto.JS3DESEncryption(CurrentUserUtil.getCurentUserId(), currentPassWord);
            String oriPassWordEncrypt = MD5Crypto.encrypt(oriPassWord, CurrentUserUtil.getCurentUserId());
            SysUser user = userMapper.selectByPrimaryKey(CurrentUserUtil.getCurentUserId());
            if (user == null) {
                result.setSuccess(false, CodeEnum.E_500);
                return result;
            }
            if (!oriPassWordEncrypt.equals(user.getPassWord())) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
            user.setPassWord(MD5Crypto.encrypt(DESCrypto.JS3DESEncryption(CurrentUserUtil.getCurentUserId(), newPassWord), CurrentUserUtil.getCurentUserId()));
            user.setModifier(CurrentUserUtil.getCurentUserId());
            user.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
            userMapper.updateByPrimaryKey(user);
            result.setSuccess(true, CodeEnum.E_700);
        } catch (Exception e) {
            logger.error("修改密码失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }
}
