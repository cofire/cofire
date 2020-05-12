package com.cofire.basic.algorithm.sort;

/**
 * @author ly
 * @Description
 * @date 2020/04/08
 **/
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;


    protected void merge(T[] nums, int l, int m, int h) {

        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k]; // 将数据复制到辅助数组
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];

            } else if (j > h) {
                nums[k] = aux[i++];

            } else if (aux[i].compareTo(nums[j]) <= 0) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
