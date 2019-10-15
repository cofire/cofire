package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysRole;

public interface IRoleService {

    Result query(ParamItem paramItem, SysRole role);

    Result add(SysRole role);

    Result upadte(SysRole role);

    Result delete(SysRole role);
}
