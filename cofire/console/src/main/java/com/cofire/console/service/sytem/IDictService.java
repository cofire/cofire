package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysDict;

public interface IDictService {

    Result query(ParamItem paramItem, SysDict dict);

    Result add(SysDict dict);

    Result upadte(SysDict dict);

    Result delete(SysDict dict);
}
