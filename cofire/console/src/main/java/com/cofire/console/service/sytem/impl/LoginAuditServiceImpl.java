package com.cofire.console.service.sytem.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

/**
 * 
 * @ClassName: LoginAuditServiceImpl
 * @Description:登录登出日志
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
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
        Result result = new Result(true);
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
        PageHelper.startPage(paramItem.getPage(), paramItem.getLength());
        List<SysLoginAudit> loginAuditList = loginAuditMapper.selectByExample(loginAuditExample);
        PageInfo<SysLoginAudit> pageInfo = new PageInfo<>(loginAuditList);
        result.setTotal(pageInfo.getTotal());
        result.setData(loginAuditList);
        logger.info("查询定时任务日志信息完成");
        return result;
    }
}
