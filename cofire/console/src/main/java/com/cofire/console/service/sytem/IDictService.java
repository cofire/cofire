package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.SysDict;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IDictService
 * @Description:数据字典
 * @date 2019年12月4日
 */
public interface IDictService {

    /**
     * 数据字典分页查询
     *
     * @param paramItem
     * @param dict
     * @return
     */
    Result query(ParamItem paramItem, SysDict dict);

    /**
     * 数据字典新增
     *
     * @param dict
     * @return
     */
    Result add(SysDict dict);

    /**
     * 数据字典修改
     *
     * @param dict
     * @return
     */
    Result update(SysDict dict);

    /**
     * 数据字典删除
     *
     * @param dict
     * @return
     */
    Result delete(SysDict dict);
}
