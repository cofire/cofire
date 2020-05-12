package com.cofire.basic.algorithm.sort;/**
 * @author hardy
 * @date 2020/04/09
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description
 * @ClassName BucketSort
 * @Author Ly
 * @date 2020.04.09 17:20
 */
public class BucketSort {
    public static void bucketSort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }

    public static void main(String[] args) {
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        bucketSort(a);
    }
}
