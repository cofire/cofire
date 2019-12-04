package com.cofire.console.service.sytem.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.cofire.common.result.TreeNode;
import com.cofire.common.utils.collection.TreeUtil;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.string.DateUtils;
import com.cofire.common.utils.string.StringUtil;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IRoleService;
import com.cofire.dao.mapper.system.SysResourceMapper;
import com.cofire.dao.mapper.system.SysRoleResourceMapper;
import com.cofire.dao.mapper.system.SysUserRoleMapper;
import com.cofire.dao.mapper.system.impl.SysRoleMapperImpl;
import com.cofire.dao.model.system.SysResource;
import com.cofire.dao.model.system.SysResourceExample;
import com.cofire.dao.model.system.SysRole;
import com.cofire.dao.model.system.SysRoleExample;
import com.cofire.dao.model.system.SysRoleResource;
import com.cofire.dao.model.system.SysRoleResourceExample;
import com.cofire.dao.model.system.SysUser;
import com.cofire.dao.model.system.SysUserRole;
import com.cofire.dao.model.system.SysUserRoleExample;

/**
 * 
 * @ClassName: RoleServiceImpl
 * @Description: 角色管理
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    @Autowired
    private SysResourceMapper resourceMapper;
    @Autowired
    private SysRoleResourceMapper roleResourceMapper;

    @Autowired
    private SysRoleMapperImpl sysRoleMapperImpl;

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
            count = sysRoleMapperImpl.countByExample(roleExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null == paramItem) {
            paramItem = new ParamItem();
            paramItem.setSort("role_id");
        }
        if (StringUtils.isNotBlank(paramItem.getSort())) {
            paramItem.setSort(StringUtil.humpToLine(paramItem.getSort()));
        } else {
            paramItem.setSort("role_id");
        }
        roleExample.setDatabaseId(Constants.MYSQL);
        roleExample.setOrderByClause(paramItem.getOrderByClause());
        roleExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
        List<SysRole> roleList = null;
        try {
            // 获取数据集
            roleList = sysRoleMapperImpl.selectPageByExample(roleExample);
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
    public Result add(SysRole role, String permission) {
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
        List<SysRole> roleList = sysRoleMapperImpl.selectByExample(roleExample);
        if (roleList.size() > 0) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            role.setModifier(CurrentUserUtil.getCurrentUserId());
            role.setModifyTime(Util.getCurrentDateTimeString());
            sysRoleMapperImpl.insert(role);
            SysRoleResourceExample example = new SysRoleResourceExample();
            SysRoleResourceExample.Criteria roleResourcecriteria = example.createCriteria();
            roleResourcecriteria.andRoleIdEqualTo(role.getRoleId());
            roleResourceMapper.deleteByExample(example);
            if (StringUtils.isNotBlank(permission)) {
                String[] resouceArray = permission.split(",");
                HashSet<String> resouceSet = new HashSet<>();
                CollectionUtils.addAll(resouceSet, resouceArray);
                for (String resouce : resouceSet) {
                    SysRoleResource roleResource = new SysRoleResource();
                    roleResource.setRoleId(role.getRoleId());
                    roleResource.setResourceId(resouce);
                    roleResource.setModifier(CurrentUserUtil.getCurrentUserId());
                    roleResource.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
                    roleResourceMapper.insertSelective(roleResource);
                }
            }
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增角色信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: update
     * @author ly
     * @Description:角色信息
     * @param @param role
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(SysRole role, String permission) {
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
        try {
            logger.info("正在修改角色信息");
            SysRoleExample roleExample = new SysRoleExample();
            SysRoleExample.Criteria roleCriteria = roleExample.createCriteria();
            roleCriteria.andRoleIdEqualTo(role.getRoleId());
            role.setModifier(CurrentUserUtil.getCurrentUserId());
            role.setModifyTime(Util.getCurrentDateTimeString());
            sysRoleMapperImpl.updateByExample(role, roleExample);
            SysRoleResourceExample example = new SysRoleResourceExample();
            SysRoleResourceExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(role.getRoleId());
            roleResourceMapper.deleteByExample(example);
            if (StringUtils.isNotBlank(permission)) {
                String[] resouceArray = permission.split(",");
                HashSet<String> resouceSet = new HashSet<>();
                CollectionUtils.addAll(resouceSet, resouceArray);
                for (String resouce : resouceSet) {
                    SysRoleResource roleResource = new SysRoleResource();
                    roleResource.setRoleId(role.getRoleId());
                    roleResource.setResourceId(resouce);
                    roleResource.setModifier(CurrentUserUtil.getCurrentUserId());
                    roleResource.setModifyTime(DateUtils.dataTimeToNumber(new Date()));
                    roleResourceMapper.insertSelective(roleResource);
                }
            }
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改角色信息失败：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
            sysRoleMapperImpl.deleteByExample(roleExample);
            SysRoleResourceExample example = new SysRoleResourceExample();
            SysRoleResourceExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(role.getRoleId());
            roleResourceMapper.deleteByExample(example);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除角色信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }

    /**
     * 
     * @Title: queryUserRoleList
     * @author ly
     * @Description:查询用户角色列表，用户已有的角色 checked为 true
     * @param @param role
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result queryUserRoleList(SysUser user) {
        logger.info("正在查询用户的角色信息:" + user.getUserId());
        Result result = new Result();
        try {
            SysUserRoleExample example = new SysUserRoleExample();
            SysUserRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(user.getUserId());
            List<SysUserRole> userRoleList = userRoleMapper.selectByExample(example);
            result.setData(userRoleList);
            result.setSuccess(true, CodeEnum.E_600);
        } catch (Exception e) {
            logger.error("删除角色信息失败:" + e.getMessage());
            result.setSuccess(true, CodeEnum.E_601);
        }
        return result;
    }

    /**
     * 
     * @Title: getRoleTree
     * @author ly
     * @Description:查询角色权限列表
     * @param @param roleId
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result getRoleTree(String roleId) {
        Result result = new Result();
        Set<String> checkedSet = new HashSet<>();
        List<TreeNode> treeList = new ArrayList<>();
        try {
            SysResourceExample resourceExample = new SysResourceExample();
            resourceExample.setOrderByClause("morder");
            List<SysResource> resourceList = resourceMapper.selectByExample(resourceExample);
            for (SysResource resource : resourceList) {
                TreeNode node = new TreeNode(resource.getResourceId(), resource.getResourceName(), resource.getParentResourceId());
                treeList.add(node);
            }

            if (StringUtils.isNotBlank(roleId)) {
                // 只查该角色的菜单列表的子节点
                List<SysRoleResource> checkedList = sysRoleMapperImpl.getRoleLeafResource(roleId);
                for (SysRoleResource roleResource : checkedList) {
                    checkedSet.add(roleResource.getResourceId());
                }
            }
            HashMap<String, Object> resultMap = new HashMap<>(20);
            resultMap.put("resourceTree", TreeUtil.buildByRecursive(treeList));
            resultMap.put("checked", checkedSet);
            result.setData(resultMap);
            result.setSuccess(true, CodeEnum.E_600);
        } catch (Exception e) {
            logger.error("查询菜单列表失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_601);
        }

        return result;
    }
}
