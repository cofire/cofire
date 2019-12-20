package com.cofire.console.service.sytem.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import com.cofire.common.utils.string.StringUtil;
import com.cofire.common.utils.validate.ParamValidator;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.common.impl.SystemService;
import com.cofire.console.service.sytem.IParamService;
import com.cofire.dao.mapper.system.SysParamMapper;
import com.cofire.dao.model.system.SysParam;
import com.cofire.dao.model.system.SysParamExample;

/**
 * 
 * @ClassName: ParamServiceImpl
 * @Description:系统参数管理
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@Service
public class ParamServiceImpl implements IParamService {

    private final static Logger logger = LoggerFactory.getLogger(ParamServiceImpl.class);
    @Autowired
    private SysParamMapper paramMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询系统参数信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysParam param) {
        logger.info("正在查询系统参数信息");
        Result result = new Result();
        SysParamExample paramExample = new SysParamExample();
        SysParamExample.Criteria criteria = paramExample.createCriteria();
        if (null != param) {
            // 判断params.getGroupId()的值是否为null或者为空
            if (StringUtils.isNotEmpty(param.getGroupId())) {
                criteria.andGroupIdLike("%" + param.getGroupId() + "%");
            }
            if (StringUtils.isNotEmpty(param.getParamId())) {
                criteria.andParamIdLike("%" + param.getParamId() + "%");
            }
            // 这里对应方法绑定对应字段 曾有出错
            if (StringUtils.isNotEmpty(param.getParamName())) {
                criteria.andParamNameLike("%" + param.getParamName() + "%");
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysParam> paramList = paramMapper.selectByExample(paramExample);
        PageInfo<SysParam> pageInfo = new PageInfo<>(paramList);
        result.setTotal(pageInfo.getTotal());
        result.setData(paramList);
        logger.info("查询系统参数信息完成");
        return result;
    }

    /**
     * 新增系统参数信息
     */
    @Override
    public Result add(SysParam param) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(param, "paramId", "paramNmae")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysParam paramTmp = paramMapper.selectByPrimaryKey(param.getGroupId(), param.getParamValue());
        if (paramTmp != null) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            param.setModifier(CurrentUserUtil.getCurrentUserId());
            param.setModifyTime(Util.getCurrentDateTimeString());
            paramMapper.insert(param);
            SystemService.initSysParam();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增系统参数信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: update
     * @author ly
     * @Description:系统参数信息
     * @param @param param
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result update(SysParam param) {
        Result result = new Result();
        try {
            logger.info("正在修改系统参数信息");
            SysParamExample example = new SysParamExample();
            SysParamExample.Criteria criteria = example.createCriteria();
            criteria.andGroupIdEqualTo(param.getGroupId());
            criteria.andParamIdEqualTo(param.getParamId());
            param.setModifier(CurrentUserUtil.getCurrentUserId());
            param.setModifyTime(Util.getCurrentDateTimeString());
            paramMapper.updateByExample(param, example);
            SystemService.initSysParam();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改系统参数信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除系统参数信息
     * @param @param param
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(SysParam param) {
        logger.info("正在删除系统参数信息");
        Result result = new Result();
        try {
            logger.info("开始删除系统参数信息");
            // 根据主键删除对应记录
            paramMapper.deleteByPrimaryKey(param.getGroupId(), param.getParamId());
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除系统参数信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
