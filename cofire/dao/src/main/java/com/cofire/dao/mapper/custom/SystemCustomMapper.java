package com.cofire.dao.mapper.custom;

import java.util.List;
import java.util.Map;

public interface SystemCustomMapper {

    /**
     * @return List<Map < String, String>> 返回类型
     * @Title: getSysparams
     * @Description:获取所有的系统参数
     */
    List<Map<String, String>> getSysparamsList();

    /**
     * @return List<Map < String, String>> 返回类型
     * @Title: getDictList
     * @Description:获取所有的数据字典
     */
    List<Map<String, String>> getDictList();
}
