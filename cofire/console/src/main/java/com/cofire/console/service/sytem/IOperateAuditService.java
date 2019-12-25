package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysOperateAudit;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IOperateAuditService
 * @Description:操作日志
 * @date 2019年12月4日
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
