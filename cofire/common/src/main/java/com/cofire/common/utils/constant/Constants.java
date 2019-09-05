package com.cofire.common.utils.constant;

/**
 * @author: hxy
 * @description: 通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 * @date: 2017/10/24 10:15
 */
public class Constants {

    public static final String SUCCESS_CODE = "100";
    public static final String SUCCESS_MSG = "请求成功";

    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";
    /**
     * @Author yongLiangMa
     * @Description //TODO 消防点名中的 安全区名称和是否已到安全区
     * @Date 09:49 2019-07-31
     **/
    public static final String eastSafeArea = "Emergencypoint E";
    public static final String westSafeArea = "EmergencyPoint_W";
    public static final String arriveSafeArea = "已到安全区";
    public static final String notArriveSafeArea = "未到安全区";

}
