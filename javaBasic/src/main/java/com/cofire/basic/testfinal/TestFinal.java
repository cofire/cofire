package com.cofire.basic.testfinal;

import java.util.HashMap;

public class TestFinal {
    public static HashMap<String, String> testMap = new HashMap<>();

    public static void main(String[] args) {
        testMap.put("test", "test");
        System.out.println(testMap.get("test"));

        HashMap<String, String> testMap = new HashMap<>();
        System.gc();
    }
}
