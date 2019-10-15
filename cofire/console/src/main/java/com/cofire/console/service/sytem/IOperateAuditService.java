package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysOperateAudit;

public interface IOperateAuditService {

    Result query(ParamItem paramItem, SysOperateAudit operateAudit);
}
