package com.cofire.basic.generic;

import java.util.List;

public class Test {

    public static <E> void get(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("111");
    }

    public static <E> void toString(E data) {
        System.out.println("" + data);
    }

    public static void main(String[] args) {
        Integer aInteger = 1234;
        Short short1 = 12;
        Double double1 = 12.0;
        Float float1 = 12.0F;
        String string = "121334";
        System.out.println(aInteger.toString());
        toString(aInteger);
        toString(short1);
        toString(double1);
        toString(float1);
        toString(string);
    }
}
