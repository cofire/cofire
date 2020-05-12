package com.cofire.basic.algorithm.sort;


/**
 * @author ly
 * @Description
 * @date 2020/04/07
 **/
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    /**
     * 判断两个值的大小
     * 数值型和字符型都适用
     **/
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中两个值的位置
     **/
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     **/
    protected void print(T[] nums) {
        for (T num : nums) {
            System.out.print(num);
            System.out.print("\t");
        }
    }
}
