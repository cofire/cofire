package com.cofire.utils.basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {

        System.out.println("Radix sort in Java");
        int[] input = { 181, 51, 11, 33, 11, 39, 60, 2, 27, 24, 12 };

        System.out.println("An Integer array before sorting");
        System.out.println(Arrays.toString(input));

        // sorting array using radix Sort Algorithm
        radixSort(input);

        System.out.println("Sorting an int array using radix sort algorithm");
        System.out.println(Arrays.toString(input));

    }

    /**
     * Java method to sort a given array using radix sort algorithm
     * 
     * @param input
     */
    public static void radixSort(int[] input) {
        final int RADIX = 10;

        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;

            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            // move to next digit
            placement *= RADIX;
        }
    }
}
