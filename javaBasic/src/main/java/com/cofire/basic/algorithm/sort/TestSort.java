package com.cofire.basic.algorithm.sort;

/**
 * @author ly
 * @Description
 * @date 2020/04/08
 **/
public class TestSort {
    public static void main(String[] args) {
        String[] a = {"p", "v", "c", "o", "a", "u", "i", "q", "e", "r"};
        QuickSort testSort = new QuickSort<String>();
//        System.out.println(bubble.less("c", "a"));
        testSort.sort(a);
        testSort.print(a);

    }
}
