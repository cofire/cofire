package com.cofire.console.service.sytem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.Result;
import com.cofire.common.utils.security.Util;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.service.sytem.IResourceService;
import com.cofire.dao.mapper.system.SysResourceMapper;
import com.cofire.dao.model.custom.ResourceCustomModel;
import com.cofire.dao.model.system.SysResource;
import com.cofire.dao.model.system.SysResourceExample;

@Service
public class ResourceServiceImpl implements IResourceService {

    private final static Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
    @Autowired
    private SysResourceMapper resourceMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询菜单信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query() {
        logger.info("正在查询菜单信息");
        Result result = new Result();

        List<SysResource> resourceList = new ArrayList<>();
        List<ResourceCustomModel> resourceTreeList = new ArrayList<>();
        try {
            // 获取数据集
            SysResourceExample example = new SysResourceExample();
            example.setOrderByClause("is_leaf,morder");
            resourceList = resourceMapper.selectByExample(example);
            for (SysResource resource : resourceList) {
                ResourceCustomModel resourceTreeNode = new ResourceCustomModel();
                BeanUtils.copyProperties(resourceTreeNode, resource);
                if (StringUtils.isBlank(resourceTreeNode.getParentResourceId()) || Constants.MENU_ROOT.equals(resourceTreeNode.getParentResourceId())) {
                    resourceTreeList.add(resourceTreeNode);
                }

                for (SysResource childResource : resourceList) {
                    ResourceCustomModel childNode = new ResourceCustomModel();
                    BeanUtils.copyProperties(childNode, childResource);
                    if (childNode.getParentResourceId().equals(resourceTreeNode.getResourceId())) {
                        if (resourceTreeNode.getChildren() == null) {
                            resourceTreeNode.setChildren(new ArrayList<ResourceCustomModel>());
                        }
                        resourceTreeNode.getChildren().add(childNode);
                    }
                }
            }
            result.setSuccess(true, CodeEnum.E_200);
            result.setData(resourceTreeList);
        } catch (Exception e) {
            logger.error("查询菜单信息失败：" + e.getMessage());
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        logger.info("查询菜单信息完成");
        return result;
    }

    /**
     * 新增菜单信息
     */
    @Override
    public Result add(SysResource resource) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(resource, "resourceId", "resourceNmae")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysResource resourceTmp = resourceMapper.selectByPrimaryKey(resource.getResourceId());
        if (resourceTmp != null) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            resource.setModifier(CurrentUserUtil.getCurentUserId());
            resource.setModifyTime(Util.getCurrentDateTimeString());
            resourceMapper.insert(resource);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增菜单信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: upadte
     * @author ly
     * @Description:菜单信息
     * @param @param resource
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result upadte(SysResource resource) {
        Result result = new Result();
        try {
            logger.info("正在修改菜单信息");
            SysResourceExample example = new SysResourceExample();
            SysResourceExample.Criteria criteria = example.createCriteria();
            criteria.andResourceIdEqualTo(resource.getResourceId());
            resource.setModifier(CurrentUserUtil.getCurentUserId());
            resource.setModifyTime(Util.getCurrentDateTimeString());
            resourceMapper.updateByExample(resource, example);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改菜单信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除菜单信息
     * @param @param resource
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(SysResource resource) {
        logger.info("正在删除菜单信息");
        Result result = new Result();
        try {
            logger.info("开始删除菜单信息");
            // 根据主键删除对应记录
            resourceMapper.deleteByPrimaryKey(resource.getResourceId());
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除菜单信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
