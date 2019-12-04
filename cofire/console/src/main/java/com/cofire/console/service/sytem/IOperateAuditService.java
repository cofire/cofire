package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysOperateAudit;

/**
 * 
 * @ClassName: IOperateAuditService
 * @Description:操作日志
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public interface IOperateAuditService {
    /**
     * 操作日志插叙
     * 
     * @param paramItem
     * @param operateAudit
     * @return
     */
    Result query(ParamItem paramItem, SysOperateAudit operateAudit);
}
