package com.cofire.console.service.sytem;

import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysResource;

public interface IResourceService {

    Result query();

    Result add(SysResource resource);

    Result upadte(SysResource resource);

    Result delete(SysResource resource);
}
