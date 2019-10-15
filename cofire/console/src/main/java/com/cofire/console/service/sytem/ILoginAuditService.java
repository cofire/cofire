package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysLoginAudit;

public interface ILoginAuditService {

    Result query(ParamItem paramItem, SysLoginAudit loginAudit);

}
