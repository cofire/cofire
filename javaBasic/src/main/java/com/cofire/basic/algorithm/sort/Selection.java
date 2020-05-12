package com.cofire.basic.algorithm.sort;

/**
 * @author ly
 * @Description
 * @date 2020/04/08
 **/
public class Selection<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        String[] a = {"p", "v", "c", "o", "a", "u", "i", "q", "e", "r"};
        Selection Selection = new Selection<String>();
//        System.out.println(bubble.less("c", "a"));
        Selection.sort(a);
        Selection.print(a);

    }

    /**
     * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
     * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
     **/
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, min, i);
            }
        }
    }
}
