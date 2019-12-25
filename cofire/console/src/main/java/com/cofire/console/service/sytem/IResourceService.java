package com.cofire.console.service.sytem;

import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysResource;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IResourceService
 * @Description:菜单
 * @date 2019年12月4日
 */
public interface IResourceService {
    /**
     * 菜单查询
     *
     * @return
     */
    Result query();

    /**
     * 菜单新增
     *
     * @param resource
     * @return
     */
    Result add(SysResource resource);

    /**
     * 菜单修改
     *
     * @param resource
     * @return
     */
    Result update(SysResource resource);

    /**
     * 菜单删除
     *
     * @param resource
     * @return
     */
    Result delete(SysResource resource);
}
