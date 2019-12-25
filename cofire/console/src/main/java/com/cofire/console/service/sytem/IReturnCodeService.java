package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysReturnCode;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IReturnCodeService
 * @Description:返回码
 * @date 2019年12月4日
 */
public interface IReturnCodeService {
    /**
     * 返回码查询
     *
     * @param paramItem
     * @param dict
     * @return
     */
    Result query(ParamItem paramItem, SysReturnCode dict);

    /**
     * 返回码新增
     *
     * @param dict
     * @return
     */
    Result add(SysReturnCode dict);

    /**
     * 返回码修改
     *
     * @param dict
     * @return
     */
    Result update(SysReturnCode dict);

    /**
     * 返回码删除
     *
     * @param dict
     * @return
     */
    Result delete(SysReturnCode dict);
}
