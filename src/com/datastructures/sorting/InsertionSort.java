package com.datastructures.sorting;

/**
 *
 * Can use this if inout is small and items are mostly sorted then insertion sort is fast.
 * Time Complexity: O(n^2)
 * Space : O(1)
 *
 */
public class InsertionSort {
    public static void main(String args[]) {
        int[] array = {41, 5, 14, 6, 9, 24, 35, 75, 38, 65};
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("#####################################3");
        int[] result = insertionSort(array);
        for (int i :
                result) {
            System.out.println(i);
        }
    }

    private static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
