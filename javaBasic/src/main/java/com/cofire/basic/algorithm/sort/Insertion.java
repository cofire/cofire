package com.cofire.basic.algorithm.sort;

/**
 * @author ly
 * @Description
 * @date 2020/04/08
 **/
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    /**
     * 类似摸牌
     **/
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }
}
