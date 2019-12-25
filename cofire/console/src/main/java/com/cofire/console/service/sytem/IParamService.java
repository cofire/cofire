package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysParam;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IParamService
 * @Description:系统参数
 * @date 2019年12月4日
 */
public interface IParamService {
    /**
     * 系统参数查询
     *
     * @param paramItem
     * @param param
     * @return
     */
    Result query(ParamItem paramItem, SysParam param);

    /**
     * 系统参数新增
     *
     * @param param
     * @return
     */
    Result add(SysParam param);

    /**
     * 系统参数修改
     *
     * @param param
     * @return
     */
    Result update(SysParam param);

    /**
     * 系统参数删除
     *
     * @param param
     * @return
     */
    Result delete(SysParam param);
}
