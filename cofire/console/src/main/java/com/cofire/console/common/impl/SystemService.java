package com.cofire.console.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofire.common.result.SystemUtil;
import com.cofire.common.utils.collection.MapUtil;
import com.cofire.common.utils.spring.SpringContextUtils;
import com.cofire.dao.mapper.custom.SystemCustomMapper;

/**
 * 
 * @ClassName: SystemService
 * @Description: 系统参数管理（系统参数和数据字典）
 * @date 2019年5月5日
 *
 */
public class SystemService {
    private final static Logger logger = LoggerFactory.getLogger(SystemService.class);

    private final static SystemCustomMapper systemCustomMapper = SpringContextUtils.getBean(SystemCustomMapper.class);;

    // 系统参数列表
    private static List<Map<String, String>> sysParamList;
    // 系统参数Map
    private static Map<String, Map<String, String>> sysParamMap = new HashMap<>();
    // 数据字典列表
    private static List<Map<String, String>> dictList = new ArrayList<Map<String, String>>();
    // 数据字典分组
    private static Map<String, List<Map<String, String>>> dictGroupMap = new HashMap<String, List<Map<String, String>>>();
    // 数据字典
    private static Map<String, Map<String, String>> dtDictMap = new HashMap<String, Map<String, String>>();

    /**
     * 
     * @Title: initSysParam
     * @Description:初始化系统参数
     * @return void 返回类型
     */
    public static void initSysParam() {
        logger.info("正在初始化系统参数");
        try {
            sysParamList = systemCustomMapper.getSysparamsList();
            if (!CollectionUtils.isEmpty(sysParamList)) {
                sysParamMap = MapUtil.list2Map(sysParamList, "PK_ID");
                SystemUtil.sysParamMap = sysParamMap;
                logger.info("系统参数：" + sysParamMap);
            } else {
                logger.info("系统参数为空");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("初始化系统参数失败");
            return;
        }

        logger.info("初始化系统参数完成");
    }

    /**
     * 
     * @Title: initSysParam
     * @Description:初始化系统数据字典
     * @return void 返回类型
     */
    public static void initSysDict() {
        logger.info("正在初始化数据字典");
        try {
            dictList = systemCustomMapper.getDictList();
            if (!CollectionUtils.isEmpty(dictList)) {
                MapUtil.list2Map(dictList, "PK_ID");
                dictGroupMap = MapUtil.listGroup2Map(dictList, "GROUP_ID");
                dtDictMap = MapUtil.list2Map(dictList, "PK_ID");
                SystemUtil.dictGroupMap = dictGroupMap;
                SystemUtil.dtDictMap = dtDictMap;
                logger.info("数据字典列表：：" + dtDictMap);
                logger.info("数据字典分组：：" + dictGroupMap);
            } else {
                logger.info("数据字典为空");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("初始化数据字典失败");
            return;
        }
        logger.info("初始化数据字典完成");
    }

    /**
     * 
     * @Title: getDictList
     * @Description:根据组好获取数据字典列表
     * @param groupCode
     * @return
     * @return List<Map<String,String>> 返回类型
     */
    public static List<Map<String, String>> getDictList(String groupCode) {
        if (StringUtils.isEmpty(groupCode)) {
            return null;
        }
        return dictGroupMap.get(groupCode);
    }

    /**
     * 
     * @Title: getParamVal
     * @author ly
     * @Description:通过组号和参数号获取系统参数的值
     * @param @param groupCode
     * @param @param paramId
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getParamVal(String groupCode, String paramId) {
        if (StringUtils.isEmpty(groupCode) || StringUtils.isEmpty(paramId)) {
            return "";
        }
        Map<String, String> paramMap = sysParamMap.get(groupCode + "|" + paramId);
        if (null == paramMap) {
            return "";
        }
        return paramMap.get("PARAM_VAL");
    }

    /**
     * 
     * @Title: getDictName
     * @author ly
     * @Description: 获取数据字典的名称
     * @param @param groupCode
     * @param @param dictVal
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getDictName(String groupCode, String dictVal) {
        if (StringUtils.isEmpty(groupCode)) {
            return "";
        }
        if (StringUtils.isEmpty(dictVal)) {
            dictVal = "";
        }
        String pkId = groupCode + "|" + dictVal;
        Map<String, String> dictMap = dtDictMap.get(pkId);
        if (dictMap == null || dictMap.isEmpty() || dictMap.size() <= 0) {
            return "";
        }
        return dictMap.get("DICT_NAME");
    }
}
