package com.cofire.console.service.sytem.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.constant.CodeEnum;
import com.cofire.common.utils.constant.Constants;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.console.service.sytem.IOperateAuditService;
import com.cofire.dao.mapper.system.SysOperateAuditMapper;
import com.cofire.dao.model.system.SysOperateAudit;
import com.cofire.dao.model.system.SysOperateAuditExample;

@Service
public class OperateAuditServiceImpl implements IOperateAuditService {

    private final static Logger logger = LoggerFactory.getLogger(OperateAuditServiceImpl.class);
    @Autowired
    private SysOperateAuditMapper operateAuditMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询操作日志信息
     * @param @param paramItem
     * @param @param operateAudit
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysOperateAudit operateAudit) {
        logger.info("正在查询操作日志信息");
        Result result = new Result();
        SysOperateAuditExample operateAuditExample = new SysOperateAuditExample();
        SysOperateAuditExample.Criteria criteria = operateAuditExample.createCriteria();
        if (null != operateAudit) {
            if (StringUtils.isNotBlank(operateAudit.getUserId())) {
                criteria.andUserIdLike("%" + operateAudit.getUserId() + "%");
            }
            if (StringUtils.isNotBlank(operateAudit.getIp())) {
                criteria.andIpLike("%" + operateAudit.getIp() + "%");
            }

            if (StringUtils.isNotEmpty(operateAudit.getDescription())) {
                criteria.andDescriptionLike("%" + operateAudit.getDescription() + "%");
            }

            if (StringUtils.isNotEmpty(operateAudit.getRequestTime())) {
                String auditTime = operateAudit.getRequestTime();
                String[] times = auditTime.split(",");
                System.out.println(JSON.toJSONString(operateAudit.getRequestTime()));
                criteria.andRequestTimeBetween(times[0], times[1]);
            }
        }
        Long count = 0L;
        try {
            // 获取数据总和
            count = operateAuditMapper.countByExample(operateAuditExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null != paramItem) {
            if (null != paramItem.getPage() && null != paramItem.getLength()) {
                operateAuditExample.setDatabaseId(Constants.MYSQL);
                operateAuditExample.setOrderByClause("operateAudit_id DESC");
                operateAuditExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
            }
        }
        List<SysOperateAudit> operateAuditList = null;
        try {
            // 获取数据集
            operateAuditList = operateAuditMapper.selectPageByExample(operateAuditExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询操作日志信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
        result.setData(operateAuditList);
        logger.info("查询操作日志信息完成");
        return result;
    }
}
