package com.cofire.basic.dataType;

public class StringObject {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        String str3 = "abc";
        System.out.println(str1 == str3);
        String str4 = new String("abc");
        System.out.println(str2 == str4);
        System.out.println(str2.equals(str4));

    }
}
