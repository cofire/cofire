package com.cofire.common.utils.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * @ClassName: MapUtil
 * @Description:Map 工具类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class MapUtil {
    private static final int CHINESE_LEN = 3;

    /**
     * 特定格式的List转Map
     * 
     * @param dtList
     * @param keyStr
     * @return
     */
    public static Map<String, Map<String, String>> list2Map(List<Map<String, String>> dtList, String keyStr) {
        Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String, String>>(10);
        for (int i = 0; i < dtList.size(); i++) {
            Map<String, String> dtMap = new HashMap<String, String>(10);
            dtMap = dtList.get(i);
            resultMap.put(dtMap.get(keyStr), dtMap);
        }
        return resultMap;
    }

    /**
     * 
     * @Title: listGrouping2Map
     * @Description:listmap分组
     * @param dtList
     * @param keyStr
     * @return
     * @return Map<String,Map<String,String>> 返回类型
     */
    public static Map<String, List<Map<String, String>>> listGroup2Map(List<Map<String, String>> dtList, String keyStr) {
        Map<String, List<Map<String, String>>> resultMap = new HashMap<String, List<Map<String, String>>>(10);
        for (int i = 0; i < dtList.size(); i++) {
            Map<String, String> dtMap = new HashMap<String, String>(10);
            dtMap = dtList.get(i);
            if (CollectionUtils.isEmpty(resultMap.get(dtMap.get(keyStr)))) {
                List<Map<String, String>> dtMaps = new ArrayList<>();
                dtMaps.add(dtMap);
                resultMap.put(dtMap.get(keyStr), dtMaps);
            } else {
                resultMap.get(dtMap.get(keyStr)).add(dtMap);
            }
        }
        return resultMap;
    }

    /**
     * 
     * @Title: mapKeyCheck @Description: TODO(检查Map中的某Key值是否为空) @param @param map @param @param key @param @return
     *         设定文件 @return boolean 返回类型 @throws
     */
    public static boolean mapKeyCheck(Map map, String key) {
        if (map.containsKey(key) && map.get(key) != null && !"".equals(map.get(key).toString())) {
            return true;
        }
        return false;

    }

    /**
     * 返回map中某key的长度
     * 
     * @param map
     * @param key
     * @return
     */
    public static int mapKeyLength(Map map, String key) {
        int len = 0;
        String tmpText = map.get(key).toString();
        for (int i = 0; i < tmpText.length(); i++) {
            char c = tmpText.charAt(i);
            if (c > 255) {
                len += CHINESE_LEN;
            } else {
                len += 1;

            }
        }
        return len;
    }
}
