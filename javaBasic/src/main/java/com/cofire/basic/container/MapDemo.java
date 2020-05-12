package com.cofire.basic.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map map1 = new HashMap<>();
        map1.put("1111", "11111");
        map1.put("222", "222");
        Set set1 = map1.keySet();
        System.out.println(set1);
    }
}
