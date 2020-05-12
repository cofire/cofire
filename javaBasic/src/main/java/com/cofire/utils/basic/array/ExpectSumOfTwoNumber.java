package com.cofire.utils.basic.array;

import java.util.Arrays;
import java.util.HashSet;

public class ExpectSumOfTwoNumber {
    public static void expectSum_bySort(int[] arr, int expectSum) {
        if (arr == null || arr.length == 0)
            return;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] > expectSum)
                right--;
            else if (arr[left] + arr[right] < expectSum)
                left++;
            else// equal
            {
                System.out.println(arr[left] + " + " + arr[right] + " = " + expectSum);
                left++;
                right--;
            }
        }
    }

    public static void printPairs(int[] array, int sum) {

        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];

                if ((first + second) == sum) {
                    System.out.printf("(%d, %d) %n", first, second);
                }
            }

        }
    }

    public static void expectSum_bySet(int[] arr, int expectSum) {
        if (arr == null || arr.length == 0)
            return;
        HashSet<Integer> intSets = new HashSet<Integer>(arr.length);

        int suplement;
        for (int i : arr) {
            suplement = expectSum - i;
            if (!intSets.contains(suplement)) {
                intSets.add(i);
            } else {
                System.out.println(i + " + " + suplement + " = " + expectSum);
            }
        }
    }

    // hapjin test
    public static void main(String[] args) {
        int[] arr = { 2, 7, 4, 9, 3 };
        int expectSum = 11;
        expectSum_bySet(arr, expectSum);
        System.out.println("************");
        expectSum_bySort(arr, expectSum);
        System.out.println("----------------");
        int[] arr2 = { 3, 7, 9, 1, 2, 8, 5, 6, 10, 5 };
        int expectSum2 = 10;
        expectSum_bySet(arr2, expectSum2);
        System.out.println("**********");
        expectSum_bySort(arr2, expectSum2);
    }
}
