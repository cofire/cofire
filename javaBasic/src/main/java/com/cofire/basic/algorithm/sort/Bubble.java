package com.cofire.basic.algorithm.sort;


/**
 * @author ly
 * @Description 冒泡排序
 * @date 2020/04/07
 **/
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        String[] a = {"p", "v", "c", "o", "a", "u", "i", "q", "e", "r"};
        Bubble bubble = new Bubble<String>();
//        System.out.println(bubble.less("c", "a"));
        bubble.sort(a);
//        bubble.print(a);

    }

    /**
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出。
     **/
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        boolean hasSorted = false;
        for (int i = 0; i < n - 1 && !hasSorted; i++) {
            hasSorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
