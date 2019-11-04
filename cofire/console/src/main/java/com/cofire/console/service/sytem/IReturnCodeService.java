package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysReturnCode;

public interface IReturnCodeService {

    Result query(ParamItem paramItem, SysReturnCode dict);

    Result add(SysReturnCode dict);

    Result upadte(SysReturnCode dict);

    Result delete(SysReturnCode dict);
}
