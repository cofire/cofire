package com.cofire.designPattern.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum JobNameEnum {
    MATCHING_ASSET("MATCHING_ASSET", "Ͷ�ʽ��ƥ���ʲ�"), FILL_ASSET("FILL_ASSET", "����ծȨ�˲���"), REPEAT_INVEST("REPEAT_INVEST", "��Ͷ"), QUIT_PLAN("QUIT_PLAN",
            "Ͷ�����˳��ƻ�"), ACCEPT_DEBT("ACCEPT_DEBT", "����ծȨ�˽���δƥ��ծת"), LIQUIDATION_INCOME("LIQUIDATION_INCOME", "����Ͷ��������");
    private String code;
    private String name;

    private JobNameEnum() {
    }

    private JobNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String word) {
        this.name = word;
    }

    public static String getName(String code) {

        for (JobNameEnum item : JobNameEnum.values()) {
            if (item.getCode().equals(code)) {
                return item.getName();
            }
        }

        return null;
    }

    public static List<Map<String, String>> getCodeNameList() {
        List<Map<String, String>> m_list = new ArrayList<>();
        Map<String, String> m_map = null;
        for (JobNameEnum item : JobNameEnum.values()) {
            m_map = new HashMap<>();
            m_map.put("code", item.getCode());
            m_map.put("cnName", item.getName());
            m_list.add(m_map);
        }
        return m_list;
    }
}
