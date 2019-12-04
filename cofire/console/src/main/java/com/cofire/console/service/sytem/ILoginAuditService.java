package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysLoginAudit;

/**
 * 
 * @ClassName: ILoginAuditService
 * @Description:登录日志
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
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
