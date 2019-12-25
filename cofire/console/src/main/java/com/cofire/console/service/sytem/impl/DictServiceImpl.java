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
import com.cofire.console.service.sytem.IDictService;
import com.cofire.dao.mapper.system.SysDictMapper;
import com.cofire.dao.model.system.SysDict;
import com.cofire.dao.model.system.SysDictExample;

/**
 * 数据字典
 *
 * @author ly
 * @version V1.0
 * @ClassName: DictServiceImpl
 * @Description:
 * @date 2019年12月4日
 */

@Service
public class DictServiceImpl implements IDictService {

    private final static Logger logger = LoggerFactory.getLogger(DictServiceImpl.class);
    @Autowired
    private SysDictMapper dictMapper;

    /**
     * @param @param  paramItem
     * @param @param  user
     * @param @return 参数
     * @return Result 返回类型
     * @Title: query
     * @author ly
     * @Description:分页查询数据字典信息
     */
    @Override
    public Result query(ParamItem paramItem, SysDict dict) {
        logger.info("正在查询数据字典信息");
        Result result = new Result(true);
        SysDictExample dictExample = new SysDictExample();
        SysDictExample.Criteria criteria = dictExample.createCriteria();
        if (null != dict) {
            if (StringUtils.isNotEmpty(dict.getGroupId())) {
                criteria.andGroupIdLike("%" + dict.getGroupId() + "%");
            }
            if (StringUtils.isNotEmpty(dict.getDictValue())) {
                criteria.andDictValueLike("%" + dict.getDictValue() + "%");
            }
            if (StringUtils.isNotEmpty(dict.getDictNameCn())) {
                criteria.andDictNameCnLike("%" + dict.getDictNameCn() + "%");
            }
            if (StringUtils.isNotEmpty(dict.getDictNameEn())) {
                criteria.andDictNameEnLike("%" + dict.getDictNameEn() + "%");
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysDict> dictList = dictMapper.selectByExample(dictExample);
        PageInfo<SysDict> pageInfo = new PageInfo<>(dictList);
        result.setTotal(pageInfo.getTotal());
        result.setData(dictList);
        logger.info("查询数据字典信息完成");
        return result;
    }

    /**
     * 新增数据字典信息
     */
    @Override
    public Result add(SysDict dict) {
        Result result = new Result();
        try {
            if (ParamValidator.checkParamsHasEmpty(dict, "dictId", "dictName")) {
                result.setSuccess(false, CodeEnum.E_400);
                return result;
            }
        } catch (IllegalAccessException e) {
            logger.error("参数校验失败, {}", e.getMessage());
            e.printStackTrace();
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }

        SysDict dictTmp = dictMapper.selectByPrimaryKey(dict.getGroupId(), dict.getDictValue());
        if (dictTmp != null) {
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        try {
            dict.setModifier(CurrentUserUtil.getCurrentUserId());
            dict.setModifyTime(Util.getCurrentDateTimeString());
            dictMapper.insert(dict);
            SystemService.initSysDict();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("新增数据字典信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * @param @param  dict
     * @param @return 参数
     * @return Result 返回类型
     * @Title: update
     * @author ly
     * @Description:数据字典信息
     */
    @Override
    public Result update(SysDict dict) {
        Result result = new Result();
        try {
            logger.info("正在修改数据字典信息");
            SysDictExample example = new SysDictExample();
            SysDictExample.Criteria criteria = example.createCriteria();
            criteria.andGroupIdEqualTo(dict.getGroupId());
            criteria.andDictValueEqualTo(dict.getDictValue());
            dict.setModifier(CurrentUserUtil.getCurrentUserId());
            dict.setModifyTime(Util.getCurrentDateTimeString());
            dictMapper.updateByExample(dict, example);
            SystemService.initSysDict();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改数据字典信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * @param @param  dict
     * @param @return 参数
     * @return Result 返回类型
     * @Title: delete
     * @author ly
     * @Description:删除数据字典信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(SysDict dict) {
        logger.info("正在删除数据字典信息");
        Result result = new Result();
        try {
            logger.info("开始删除数据字典信息");
            // 根据主键删除对应记录
            dictMapper.deleteByPrimaryKey(dict.getGroupId(), dict.getDictValue());
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("删除数据字典信息失败:" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return result;
        }
        return result;
    }
}
