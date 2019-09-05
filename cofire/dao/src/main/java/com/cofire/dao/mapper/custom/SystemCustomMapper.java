package com.cofire.dao.mapper.custom;

import java.util.List;
import java.util.Map;

public interface SystemCustomMapper {

    /**
     * 
     * @Title: getSysparams
     * @Description:获取所有的系统参数
     * @return
     * @return List<Map<String,String>> 返回类型
     */
    List<Map<String, String>> getSysparamsList();

    /**
     * 
     * @Title: getDictList
     * @Description:获取所有的数据字典
     * @return
     * @return List<Map<String,String>> 返回类型
     */
    List<Map<String, String>> getDictList();
}
