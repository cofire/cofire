package com.cofire.utils.basic.array;

import java.util.Arrays;

public class ReverseArrayExample {
    public static void main(String args[]) {

        int[] iArray = new int[] { 101, 102, 103, 104, 105 };
        String[] sArray = new String[] { "one", "two", "three", "four", "five" };

        // reverse int array using Apache commons ArrayUtils.reverse() method
        System.out.println("Original int array : " + Arrays.toString(iArray));
        // ArrayUtils.reverse(iArray);
        System.out.println("reversed int array : " + Arrays.toString(iArray));

        // reverse String array using ArrayUtis class
        System.out.println("Original String array : " + Arrays.toString(sArray));
        // ArrayUtils.reverse(sArray);
        System.out.println("reversed String array in Java : " + Arrays.toString(sArray));
    }
}
