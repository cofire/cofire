package com.cofire.basic.dataType;

public class BasicTypeDemo {
    public static void main(String[] args) {
        System.out.println("Byte");
        System.out.println(Byte.MIN_VALUE); // -128
        System.out.println(Byte.MAX_VALUE); // 127

        System.out.println("Short");
        System.out.println(Short.MIN_VALUE); // -32768
        System.out.println(Short.MAX_VALUE); // 32767

        System.out.println("Character");
        System.out.println((int) Character.MIN_VALUE); // 0
        System.out.println((int) Character.MAX_VALUE); // 65535

        System.out.println("Integer");
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647

        System.out.println("Long");
        System.out.println(Long.MIN_VALUE); // -9223372036854775808
        System.out.println(Long.MAX_VALUE); // 9223372036854775807

        System.out.println("Float");
        System.out.println(Float.MIN_VALUE); // 1.4E-45, 最小精度值，而不是最小值(-Float.MAX_VALUE)
        System.out.println(Float.MAX_VALUE); // 3.4028235E38

        System.out.println("Double");
        System.out.println(Double.MIN_VALUE); // 4.9E-324，最小精度值，而不是最小值(-Double.MAX_VALUE)
        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
    }
}