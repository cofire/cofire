package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysLoginAudit;

/**
 * @author ly
 * @version V1.0
 * @ClassName: ILoginAuditService
 * @Description:登录日志
 * @date 2019年12月4日
 */
public interface ILoginAuditService {
    /**
     * 登录日志查询
     *
     * @param paramItem
     * @param loginAudit
     * @return
     */
    Result query(ParamItem paramItem, SysLoginAudit loginAudit);

}
