package com.cofire.console.service.sytem.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.common.utils.mybatis.page.Page;
import com.cofire.common.utils.string.StringUtil;
import com.cofire.console.service.sytem.ILoginAuditService;
import com.cofire.dao.mapper.system.SysLoginAuditMapper;
import com.cofire.dao.model.system.SysLoginAudit;
import com.cofire.dao.model.system.SysLoginAuditExample;

@Service
public class LoginAuditServiceImpl implements ILoginAuditService {

    private final static Logger logger = LoggerFactory.getLogger(LoginAuditServiceImpl.class);
    @Autowired
    private SysLoginAuditMapper loginAuditMapper;

    /**
     * 
     * @Title: query
     * @author ly
     * @Description:分页查询定时任务日志信息
     * @param @param paramItem
     * @param @param loginAudit
     * @param @return 参数
     * @return Result 返回类型
     */
    @Override
    public Result query(ParamItem paramItem, SysLoginAudit loginAudit) {
        logger.info("正在查询定时任务日志信息");
        Result result = new Result();
        SysLoginAuditExample loginAuditExample = new SysLoginAuditExample();
        SysLoginAuditExample.Criteria criteria = loginAuditExample.createCriteria();
        if (null != loginAudit) {
            if (StringUtils.isNotBlank(loginAudit.getUserId())) {
                criteria.andUserIdLike("%" + loginAudit.getUserId() + "%");
            }
            if (StringUtils.isNotBlank(loginAudit.getIp())) {
                criteria.andIpLike("%" + loginAudit.getIp() + "%");
            }
            if (StringUtils.isNotBlank(loginAudit.getSourceType())) {
                criteria.andSourceTypeEqualTo(loginAudit.getSourceType());
            }
            if (StringUtils.isNotBlank(loginAudit.getAuditType())) {
                criteria.andAuditTypeEqualTo(loginAudit.getAuditType());
            }
            if (StringUtils.isNotEmpty(loginAudit.getCreateTime())) {
                String auditTime = loginAudit.getCreateTime();
                String[] times = auditTime.split(",");
                criteria.andCreateTimeBetween(times[0], times[1]);
            }
        }
        Long count = 0L;
        try {
            // 获取数据总和
            count = loginAuditMapper.countByExample(loginAuditExample);
        } catch (Exception e) {
            logger.error(result.getMessage());
            return result;
        }
        if (null == paramItem) {
            paramItem = new ParamItem();
            paramItem.setSort("sid");
            paramItem.setOrder(Constants.SORT_DESC);
        }
        if (StringUtils.isNotBlank(paramItem.getSort())) {
            paramItem.setSort(StringUtil.humpToLine(paramItem.getSort()));
        } else {
            paramItem.setSort("sid");
            paramItem.setOrder(Constants.SORT_DESC);
        }
        loginAuditExample.setDatabaseId(Constants.MYSQL);
        loginAuditExample.setOrderByClause(paramItem.getOrderByClause());
        loginAuditExample.setPage(new Page(paramItem.getPage(), paramItem.getLength()));
        List<SysLoginAudit> loginAuditList = null;
        try {
            // 获取数据集
            loginAuditList = loginAuditMapper.selectPageByExample(loginAuditExample);
            result.setSuccess(true, CodeEnum.E_200);
        } catch (Exception e) {
            logger.error("查询定时任务日志信息失败");
            result.setMessage("系统错误");
            result.setSuccess(true, CodeEnum.E_500);
            return result;
        }
        result.setTotal(count);
        result.setData(loginAuditList);
        logger.info("查询定时任务日志信息完成");
        return result;
    }
}
