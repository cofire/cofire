package com.cofire.common.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @ClassName: SystemUtil
 * @Description:系统工具类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class SystemUtil {
    /** 系统参数Map */
    private static Map<String, Map<String, String>> sysParamMap = new HashMap<>();
    /** 数据字典分组 */
    private static Map<String, List<Map<String, String>>> dictGroupMap = new HashMap<String, List<Map<String, String>>>();
    /** 数据字典 */
    private static Map<String, Map<String, String>> dtDictMap = new HashMap<String, Map<String, String>>();

    public static Map<String, Map<String, String>> getSysParamMap() {
        return sysParamMap;
    }

    public static void setSysParamMap(Map<String, Map<String, String>> sysParamMap) {
        SystemUtil.sysParamMap = sysParamMap;
    }

    public static Map<String, List<Map<String, String>>> getDictGroupMap() {
        return dictGroupMap;
    }

    public static void setDictGroupMap(Map<String, List<Map<String, String>>> dictGroupMap) {
        SystemUtil.dictGroupMap = dictGroupMap;
    }

    public static Map<String, Map<String, String>> getDtDictMap() {
        return dtDictMap;
    }

    public static void setDtDictMap(Map<String, Map<String, String>> dtDictMap) {
        SystemUtil.dtDictMap = dtDictMap;
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
        return paramMap.get("param_value");
    }

    /**
     * 
     * @Title: getDictName
     * @author ly
     * @Description:
     * @param @param groupCode 数据字典组号
     * @param @param dictVal 数据字典值
     * @param @param lang 语言类型
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getDictName(String groupCode, String dictVal, String lang) {
        if (StringUtils.isEmpty(groupCode) || StringUtils.isEmpty(dictVal) || StringUtils.isEmpty(lang)) {
            return "";
        }
        String pkId = groupCode + "|" + dictVal;
        Map<String, String> dictMap = dtDictMap.get(pkId);
        if (dictMap == null || dictMap.isEmpty() || dictMap.size() <= 0) {
            return "";
        }
        return dictMap.get("dict_name_" + lang);
    }
}
