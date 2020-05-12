package com.cofire.basic.dataType;

import java.util.ArrayList;

public class WrapperDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // 自动装箱，int转化为Integer
        int data = 10;
        arrayList.add(data);

        // 自动拆箱，Integer转化为int
        int ret = arrayList.get(0);

        // 自动装包，本质是new Integer(a)。-128 ～ 127都相等，有唯一的对象
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true

        // 手动生成新的实例 ==
        Integer c = new Integer(1);
        Integer d = new Integer(1);
        System.out.println(c == d); // false

        // equals
        Integer eInteger = new Integer(1);
        Integer fInteger = new Integer(1);
        System.out.println(eInteger.equals(fInteger));
    }
}