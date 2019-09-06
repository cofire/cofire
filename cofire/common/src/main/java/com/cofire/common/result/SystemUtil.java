package com.cofire.common.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class SystemUtil {
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
