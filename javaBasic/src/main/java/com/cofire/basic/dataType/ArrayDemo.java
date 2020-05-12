package com.cofire.basic.dataType;

import java.util.Arrays;

/**
 * 
 * @author ly
 * @date 2018年8月17日
 */
public class ArrayDemo {
    public static void main(String[] args) {
        /*
         * 默认值为null，在堆中，接下来需要一一赋值
         */
        int[] intArr = new int[10];
        System.out.println(intArr[0]); // 0
        double[] doubleArr = new double[10];
        System.out.println(doubleArr[0]); // 0.0
        String[] stringArr = new String[10];
        System.out.println(stringArr[0]); // null

        // 数组初始化，数组是对象，有length属性，可以相互赋值
        int[] intArr2 = { 1, 3, 5, 7 };
        System.out.println(intArr2.length); // 4
        // 匿名数组赋值，不能指定大小，可以把new int[]去掉变为数组初始化
        int[] intArr3 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(intArr3.length); // 5

        /*
         * 二维数组
         */
        int[][] intArr4 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        for (int i = 0; i < intArr4.length; i++) {
            for (int j = 0; j < intArr4[i].length; j++) {
                System.out.printf(intArr4[i][j] + " ");
            }
            System.out.println();
        }

        int size = 10;
        int[][] intArr5 = new int[size][size];
        System.out.println(intArr5[0][0]); // 0

        String[] stringArr2 = new String[] { "hello", "world", "long", "int", "string", "turn" };
        /*
         * Arrays.sort
         */
        Arrays.sort(stringArr2);
        for (int i = 0; i < stringArr2.length; i++) {
            System.out.print(stringArr2[i] + " "); // hello int long string turn world
        }
        System.out.println();

        System.out.println(Arrays.binarySearch(stringArr2, "turn")); // 4
        /*
         * Arrays.toString
         */
        System.out.println(Arrays.toString(stringArr2)); // [hello, int, long, string, turn, world]
        /*
         * Arrays.deepToString : 二维数组
         */
        System.out.println(Arrays.deepToString(intArr4)); // [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]]
        /*
         * Arrays.copyOf : 获得新的数组，并返回，新增加的空间填null
         */
        String[] copyStringArr2 = Arrays.copyOf(stringArr2, stringArr2.length * 2);
        // [hello, int, long, string, turn, world, null, null, null, null, null, null]
        System.out.println(Arrays.toString(copyStringArr2));

        /*
         * Arrays.fill
         */
        String[] stringArr3 = new String[3];
        Arrays.fill(stringArr3, "no");
        System.out.println(Arrays.toString(stringArr3)); // [no, no, no]
    }
}
