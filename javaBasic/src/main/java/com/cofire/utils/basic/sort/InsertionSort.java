package com.cofire.utils.basic.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]) {

        // getting unsorted integer array for sorting
        int[] randomOrder = getRandomArray(9);
        System.out.println("Random Integer array before Sorting : " + Arrays.toString(randomOrder));

        // sorting array using insertion sort in Java
        insertionSort(randomOrder);
        System.out.println("Sorted array uisng insretion sort : " + Arrays.toString(randomOrder));

        // one more example of sorting array using insertion sort
        randomOrder = getRandomArray(7);
        System.out.println("Before Sorting : " + Arrays.toString(randomOrder));
        insertionSort(randomOrder);
        System.out.println("After Sorting : " + Arrays.toString(randomOrder));

        // Sorting String array using Insertion Sort in Java
        String[] cities = { "London", "Paris", "Tokyo", "NewYork", "Chicago" };
        System.out.println("String array before sorting : " + Arrays.toString(cities));
        insertionSort(cities);
        System.out.println("String array after sorting : " + Arrays.toString(cities));
    }

    public static int[] getRandomArray(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }

    /*
     * Java implementation of insertion sort algorithm to sort an integer array.
     */
    public static void insertionSort(int[] array) {

        // insertion sort starts from second element
        for (int i = 1; i < array.length; i++) {
            int numberToInsert = array[i];

            int compareIndex = i;
            while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
                array[compareIndex] = array[compareIndex - 1]; // shifting element
                compareIndex--; // moving backwards, towards index 0
            }

            // compareIndex now denotes proper place for number to be sorted
            array[compareIndex] = numberToInsert;
        }
    }

    /*
     * Method to Sort String array using insertion sort in Java. This can also sort any object array which implements
     * Comparable interface.
     */
    public static void insertionSort(Comparable[] objArray) {

        // insertion sort starts from second element
        for (int i = 1; i < objArray.length; i++) {
            Comparable objectToSort = objArray[i];

            int j = i;
            while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
                objArray[j] = objArray[j - 1];
                j--;
            }
            objArray[j] = objectToSort;
        }
    }
}
