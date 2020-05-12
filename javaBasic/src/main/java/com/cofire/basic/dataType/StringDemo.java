package com.cofire.basic.dataType;

/**
 * 字符串demo
 * 
 * @author ly
 * @date 2018年8月17日
 */
public class StringDemo {
    public static void main(String[] args) {
        /*
         * String相关方法
         */
        String str = "hello world";
        for (int i = 0; i < str.length(); i++) {
            System.out.printf("'%c' ", str.charAt(i));
        }
        System.out.println();
        System.out.println(str.substring(3, 7)); // lo w
        System.out.println(str.compareTo("you are here")); // -17, h - y
        System.out.println(str.indexOf("wo")); // 6
        System.out.println(str.toUpperCase()); // HELLO WORLD
        System.out.println(str); // hello world

        /*
         * 字符串格式化
         */
        String format = "you are %s";
        System.out.println(String.format(format, str)); // you are hello world
    }
}
