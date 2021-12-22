package com.datastructures.sorting;

/**
 * Selection Sort is one the elementary Sort
 * Time Complexity - O(n^2) since there are two loops
 * Space Complexity - O(1)
 * Can use this if inout is small and items are mostly sorted then insertion sort is fast.
 *
 */
public class SelectionSort {

    public static void main(String args[]) {
        int[] array = {41, 5, 14, 6, 9, 24, 35, 75, 38, 65};
        int[] array2 = {41, 5, 14, 6, 9, 24, 35, 75, 38, 65};
        int[] result = selectionSort1(array);
        int[] result2 = selectionSort2(array2);
        for (int i :
                result) {
            System.out.println(i);

        }
        System.out.println("************************************");
        for (int i :
                result2) {
            System.out.println(i);

        }
    }

    private static int[] selectionSort2(int[] array) {
        int BIG_INDEX = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[BIG_INDEX]) {
                    BIG_INDEX = j;
                }
            }
            //swap
            int temp = array[i];
            array[i] = array[BIG_INDEX];
            array[BIG_INDEX] = temp;
        }
        return array;
    }

    public static int[] selectionSort1(int[] array) {


        for (int i = 0; i < array.length; i++) {
            int SMALL_INDEX = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[SMALL_INDEX]) {
                    SMALL_INDEX = j;
                }
            }
            //swap
            int temp = array[i];
            array[i] = array[SMALL_INDEX];
            array[SMALL_INDEX] = temp;
        }
        return array;
    }
}