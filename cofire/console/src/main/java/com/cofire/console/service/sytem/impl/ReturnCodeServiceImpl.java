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
import com.cofire.console.service.sytem.IReturnCodeService;
import com.cofire.dao.mapper.system.SysReturnCodeMapper;
import com.cofire.dao.model.system.SysReturnCode;
import com.cofire.dao.model.system.SysReturnCodeExample;

/**
 * 
 * @ClassName: ReturnCodeServiceImpl
 * @Description: 返回码管理
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@Service
public class ReturnCodeServiceImpl implements IReturnCodeService {

    private final static Logger logger = LoggerFactory.getLogger(ReturnCodeServiceImpl.class);
    @Autowired
    private SysReturnCodeMapper returnCodeMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询返回码信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysReturnCode returnCode) {
        logger.info("正在查询返回码信息");
        Result result = new Result();
        SysReturnCodeExample returnCodeExample = new SysReturnCodeExample();
        SysReturnCodeExample.Criteria criteria = returnCodeExample.createCriteria();
        if (null != returnCode) {
            if (StringUtils.isNotEmpty(returnCode.getCode())) {
                criteria.andCodeEqualTo("%" + returnCode.getCode() + "%");
            }
            if (StringUtils.isNotEmpty(returnCode.getMessage())) {
                criteria.andMessageEqualTo("%" + returnCode.getMessage() + "%");
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysReturnCode> returnCodeList = returnCodeMapper.selectByExample(returnCodeExample);
        PageInfo<SysReturnCode> pageInfo = new PageInfo<>(returnCodeList);
        result.setTotal(pageInfo.getTotal());
        result.setData(returnCodeList);
        logger.info("查询返回码信息完成");
        return result;
    }

    /**
     * 新增返回码信息
     */
    @Override
    public Result add(SysReturnCode returnCode) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(returnCode, "code", "message")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysReturnCode returnCodeTmp = returnCodeMapper.selectByPrimaryKey(returnCode.getCode());
        if (returnCodeTmp != null) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            returnCode.setModifier(CurrentUserUtil.getCurrentUserId());
            returnCode.setModifyTime(Util.getCurrentDateTimeString());
            returnCodeMapper.insert(returnCode);
            SystemService.initRerurnCode();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增返回码信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: update
     * @author ly
     * @Description:返回码信息
     * @param @param returnCode
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result update(SysReturnCode returnCode) {
        Result result = new Result();
        try {
            logger.info("正在修改返回码信息");
            SysReturnCodeExample example = new SysReturnCodeExample();
            SysReturnCodeExample.Criteria criteria = example.createCriteria();
            criteria.andCodeEqualTo(returnCode.getCode());
            returnCode.setModifier(CurrentUserUtil.getCurrentUserId());
            returnCode.setModifyTime(Util.getCurrentDateTimeString());
            returnCodeMapper.updateByExample(returnCode, example);
            returnCodeMapper.updateByPrimaryKeySelective(returnCode);
            SystemService.initRerurnCode();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改返回码信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除返回码信息
     * @param @param returnCode
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(SysReturnCode returnCode) {
        logger.info("正在删除返回码信息");
        Result result = new Result();
        try {
            logger.info("开始删除返回码信息");
            // 根据主键删除对应记录
            returnCodeMapper.deleteByPrimaryKey(returnCode.getCode());
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除返回码信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
