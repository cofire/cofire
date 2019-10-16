package com.cofire.console.service.sytem.impl;

import java.util.List;

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
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IRoleService;
import com.cofire.dao.mapper.system.SysRoleMapper;
import com.cofire.dao.model.system.SysRole;
import com.cofire.dao.model.system.SysRoleExample;

@Service
public class RoleServiceImpl implements IRoleService {

    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private SysRoleMapper roleMapper;

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
    public Result query(ParamItem paramItem, SysRole role) {
        logger.info("正在查询角色信息");
        Result result = new Result();
        SysRoleExample roleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = roleExample.createCriteria();
        if (null != role) {
            logger.info("查询条件为" + role);
            if (StringUtils.isNotEmpty(role.getRoleId())) {
                criteria.andRoleIdLike("%" + role.getRoleId() + "%");
            }
            if (StringUtils.isNotEmpty(role.getRoleName())) {
                criteria.andRoleNameLike("%" + role.getRoleName() + "%");
            }
        }
        Long count = 0L;
        try {
            // 获取数据总和
            count = roleMapper.countByExample(roleExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                roleExample.setDatabaseId(Constants.MYSQL);
                roleExample.setOrderByClause("role_id DESC");
                roleExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<SysRole> roleList = null;
        try {
            // 获取数据集
            roleList = roleMapper.selectPageByExample(roleExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询角色信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
        result.setData(roleList);
        logger.info("查询角色信息完成");
        return result;
    }

    /**
     * 新增角色信息
     */
    @Override
    public Result add(SysRole role) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(role, "roleId", "roleNmae")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysRoleExample roleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRoleIdEqualTo(role.getRoleId());
        List<SysRole> roleList = roleMapper.selectByExample(roleExample);
        if (roleList.size() > 0) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            role.setModifier(CurrentUserUtil.getCurentUserId());
            role.setModifyTime(Util.getCurrentDateTimeString());
            roleMapper.insert(role);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增角色信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: upadte
     * @author ly
     * @Description:角色信息
     * @param @param role
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result upadte(SysRole role) {
        Result result = new Result();
        try {
            logger.info("正在修改角色信息");
            SysRoleExample roleExample = new SysRoleExample();
            SysRoleExample.Criteria roleCriteria = roleExample.createCriteria();
            roleCriteria.andRoleIdEqualTo(role.getRoleId());
            role.setModifier(CurrentUserUtil.getCurentUserId());
            role.setModifyTime(Util.getCurrentDateTimeString());
            roleMapper.updateByExample(role, roleExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改角色信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除角色信息
     * @param @param role
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(SysRole role) {
        logger.info("正在删除角色信息");
        Result result = new Result();
        try {
            logger.info("开始删除角色信息");
            // 根据主键删除对应记录
            SysRoleExample roleExample = new SysRoleExample();
            SysRoleExample.Criteria roleCriteria = roleExample.createCriteria();
            roleCriteria.andRoleIdEqualTo(role.getRoleId());
            roleMapper.deleteByExample(roleExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除角色信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
