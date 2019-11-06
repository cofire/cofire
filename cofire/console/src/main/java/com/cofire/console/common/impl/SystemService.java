package com.cofire.console.common.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
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
                sysParamMap = MapUtil.list2Map(sysParamList, "pk_id");
                SystemUtil.setSysParamMap(sysParamMap);
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
                MapUtil.list2Map(dictList, "pk_id");
                dictGroupMap = MapUtil.listGroup2Map(dictList, "group_id");
                dtDictMap = MapUtil.list2Map(dictList, "pk_id");
                SystemUtil.setDictGroupMap(dictGroupMap);
                SystemUtil.setDtDictMap(dtDictMap);
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
     * @Title: initRerurnCode
     * @author ly
     * @Description:
     * @param 参数
     * @return void 返回类型
     */
    public static void initRerurnCode() {
        logger.info("正在初始化返回码");

        logger.info("初始化返回码完成");
    }
}
