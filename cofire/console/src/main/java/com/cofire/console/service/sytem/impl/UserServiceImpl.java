package com.cofire.console.service.sytem.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.file.EasyExcelUtils;
import com.cofire.common.utils.security.DESCrypto;
import com.cofire.common.utils.security.MD5Crypto;
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.string.DateUtils;
import com.cofire.common.utils.string.StringUtil;
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
import com.cofire.dao.rowModel.SysUserRowModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Author ly
 * @Description //TODO
 * @Date 11:15 2019/12/20
 * @Param
 * @return
 **/
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
     * @return
     * @Author ly
     * @Description //TODO
     * @Date 11:11 2019/12/20
     * @Param
     **/
    @Override
    public List<Map<String, String>> getUserResource(String userId) {
        List<Map<String, String>> userResourceList = userPermissionCustomMapper.getUserResource(userId);
        return userResourceList;
    }

    /**
     * @param @param  paramItem
     * @param @param  user
     * @param @return 参数
     * @return Result 返回类型
     * @Title: query
     * @author ly
     * @Description:分页查询用户信息
     */
    @Override
    public Result query(ParamItem paramItem, SysUser user) {
        logger.info("正在查询用户信息");
        Result result = new Result(true);
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
        if (null == paramItem) {
            paramItem = new ParamItem();
            paramItem.setSort("user_id");
        }
        if (StringUtils.isNotBlank(paramItem.getSort())) {
            paramItem.setSort(StringUtil.humpToLine(paramItem.getSort()));
        } else {
            paramItem.setSort("user_id");
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysUser> userList = userMapper.selectByExample(userExample);
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        result.setTotal(pageInfo.getTotal());
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
            user.setModifier(CurrentUserUtil.getCurrentUserId());
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
     * @param @param  user
     * @param @return 参数
     * @return Result 返回类型
     * @Title: update
     * @author ly
     * @Description:用户信息
     */
    @Override
    public Result update(SysUser user) {
        Result result = new Result();
        try {
            logger.info("正在修改用户信息");
            SysUserExample userExample = new SysUserExample();
            SysUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andUserIdEqualTo(user.getUserId());
            user.setModifier(CurrentUserUtil.getCurrentUserId());
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
     * @param @param  user
     * @param @return 参数
     * @return Result 返回类型
     * @Title: delete
     * @author ly
     * @Description:删除用户信息
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
     * @param @param  userId
     * @param @param  roleIds
     * @param @return 参数
     * @return Result 返回类型
     * @Title: saveUserRole
     * @author ly
     * @Description:保存用户角色信息
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
                    userRole.setModifier(CurrentUserUtil.getCurrentUserId());
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
     * @param @param  userId
     * @param @return 参数
     * @return Result 返回类型
     * @Title: restPassWord
     * @author ly
     * @Description:重置用户密码
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
     * @param @param  currentPassWord
     * @param @param  newPassWord
     * @param @param  confirmNewPassWord
     * @param @return 参数
     * @return Result 返回类型
     * @Title: changePassWord
     * @author ly
     * @Description:修改密码
     */
    @Override
    public Result changePassWord(String currentPassWord, String newPassWord, String confirmNewPassWord) {
        logger.info("正在修改密码");
        Result result = new Result();
        if (ParamValidator.checkParamsHasEmpty(CurrentUserUtil.getCurrentUserId(), currentPassWord, newPassWord, confirmNewPassWord)
                || !newPassWord.equals(confirmNewPassWord)) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            String oriPassWord = DESCrypto.JS3DESEncryption(CurrentUserUtil.getCurrentUserId(), currentPassWord);
            String oriPassWordEncrypt = MD5Crypto.encrypt(oriPassWord, CurrentUserUtil.getCurrentUserId());
            SysUser user = userMapper.selectByPrimaryKey(CurrentUserUtil.getCurrentUserId());
            if (user == null) {
                result.setSuccess(false, CodeEnum.E_500);
                return result;
            }
            if (!oriPassWordEncrypt.equals(user.getPassWord())) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
            user.setPassWord(
                    MD5Crypto.encrypt(DESCrypto.JS3DESEncryption(CurrentUserUtil.getCurrentUserId(), newPassWord), CurrentUserUtil.getCurrentUserId()));
            user.setModifier(CurrentUserUtil.getCurrentUserId());
            user.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
            userMapper.updateByPrimaryKey(user);
            result.setSuccess(true, CodeEnum.E_700);
        } catch (Exception e) {
            logger.error("修改密码失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    @Override
    public void exportExcel(SysUser user, HttpServletResponse response) {
        logger.info("正在查询用户信息");
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

        userExample.setOrderByClause("user_id DESC");
        try {
            // 获取数据集
            List<SysUser> userList = userMapper.selectByExample(userExample);
            List<SysUserRowModel> dataList = new ArrayList<SysUserRowModel>();
            for (SysUser sysUser : userList) {
                SysUserRowModel userRowModel = new SysUserRowModel();
                BeanUtils.copyProperties(sysUser, userRowModel);
                dataList.add(userRowModel);
            }
            // EasyExcelUtils.createExcelStream(response, dataList, ExcelTypeEnum.XLS, "test");
            EasyExcelUtils.createExcelStream(response, SysUserRowModel.class, dataList, ExcelTypeEnum.XLS, "test", "test1");
        } catch (Exception e) {
            logger.error("查询用户信息失败");
        }
        logger.info("查询用户信息完成");
    }
}
