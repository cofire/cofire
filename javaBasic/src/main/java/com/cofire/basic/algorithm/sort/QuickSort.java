package com.cofire.basic.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ly
 * @Description
 * @date 2020/04/08
 **/
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    public void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    public void shuffle(T[] nums) {
        List list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) {
                ;
            }
            while (less(v, nums[--j]) && j != l) {
                ;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
