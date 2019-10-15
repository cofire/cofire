package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysParam;

public interface IParamService {

    Result query(ParamItem paramItem, SysParam param);

    Result add(SysParam param);

    Result upadte(SysParam param);

    Result delete(SysParam param);
}
