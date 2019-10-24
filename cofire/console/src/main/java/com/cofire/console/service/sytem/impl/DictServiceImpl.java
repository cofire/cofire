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
import com.cofire.console.common.impl.SystemService;
import com.cofire.console.service.sytem.IDictService;
import com.cofire.dao.mapper.system.SysDictMapper;
import com.cofire.dao.model.system.SysDict;
import com.cofire.dao.model.system.SysDictExample;

@Service
public class DictServiceImpl implements IDictService {

    private final static Logger logger = LoggerFactory.getLogger(DictServiceImpl.class);
    @Autowired
    private SysDictMapper dictMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询数据字典信息
     * @param @param paramItem
     * @param @param user
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysDict dict) {
        logger.info("正在查询数据字典信息");
        Result result = new Result();
        SysDictExample dictExample = new SysDictExample();
        SysDictExample.Criteria criteria = dictExample.createCriteria();
        if (null != dict) {
            if (StringUtils.isNotEmpty(dict.getGroupId())) {
                criteria.andGroupIdLike("%" + dict.getGroupId() + "%");
            }
            if (StringUtils.isNotEmpty(dict.getDictValue())) {
                criteria.andDictValueLike("%" + dict.getDictValue() + "%");
            }
            if (StringUtils.isNotEmpty(dict.getDictName())) {
                criteria.andDictNameLike("%" + dict.getDictName() + "%");
            }
        }
        Long count = 0L;
        try {
            // 获取数据总和
            count = dictMapper.countByExample(dictExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                dictExample.setDatabaseId(Constants.MYSQL);
                dictExample.setOrderByClause("group_id,dict_value");
                dictExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<SysDict> dictList = null;
        try {
            // 获取数据集
            dictList = dictMapper.selectPageByExample(dictExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询数据字典信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
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
            if (ParamValidator.checkParamsHasEmpty(dict, "dictId", "dictNmae")) {
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
            dict.setModifier(CurrentUserUtil.getCurentUserId());
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
     * 
     * @Title: upadte
     * @author ly
     * @Description:数据字典信息
     * @param @param dict
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result upadte(SysDict dict) {
        Result result = new Result();
        try {
            logger.info("正在修改数据字典信息");
            dict.setModifier(CurrentUserUtil.getCurentUserId());
            dict.setModifyTime(Util.getCurrentDateTimeString());
            dictMapper.updateByPrimaryKeySelective(dict);
            SystemService.initSysDict();
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("修改数据字典信息失败：" + e.getMessage());
            result.setSuccess(false, CodeEnum.E_500);
        }
        return result;
    }

    /**
     * 
     * @Title: delete
     * @author ly
     * @Description:删除数据字典信息
     * @param @param dict
     * @param @return 参数
     * @return Result 返回类型
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
