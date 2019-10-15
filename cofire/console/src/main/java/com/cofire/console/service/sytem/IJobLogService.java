package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.QtzJobLog;

public interface IJobLogService {

    Result query(ParamItem paramItem, QtzJobLog jobLog);
}
