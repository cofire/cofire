package com.cofire.console.service.sytem.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.console.service.sytem.IOperateAuditService;
import com.cofire.dao.mapper.system.SysOperateAuditMapper;
import com.cofire.dao.model.system.SysOperateAudit;
import com.cofire.dao.model.system.SysOperateAuditExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author ly
 * @version V1.0
 * @ClassName: OperateAuditServiceImpl
 * @Description:操作日志
 * @date 2019年12月4日
 */
@Service
public class OperateAuditServiceImpl implements IOperateAuditService {

    private final static Logger logger = LoggerFactory.getLogger(OperateAuditServiceImpl.class);
    @Autowired
    private SysOperateAuditMapper operateAuditMapper;

    /**
     * @param @param  paramItem
     * @param @param  operateAudit
     * @param @return 参数
     * @return Result 返回类型
     * @Title: query
     * @author ly
     * @Description:分页查询操作日志信息
     */
    @Override
    public Result query(ParamItem paramItem, SysOperateAudit operateAudit) {
        logger.info("正在查询操作日志信息");
        Result result = new Result(true);
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
                criteria.andRequestTimeBetween(times[0], times[1]);
            }
        }
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysOperateAudit> operateAuditList = operateAuditMapper.selectByExample(operateAuditExample);
        PageInfo<SysOperateAudit> pageInfo = new PageInfo<>(operateAuditList);
        result.setTotal(pageInfo.getTotal());
        result.setData(operateAuditList);
        logger.info("查询操作日志信息完成");
        return result;
    }
}
