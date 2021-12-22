package com.datastructures.sorting;

/**
 * Bubble Sort
 * Least efficient of all sorts
 * Time Complexity - O(n^2) Since nested loops
 * Space Complexity - O(1)
 */
public class BubbleSort {

    public static void main(String args[]) {
        int[] array = {1, 5, 4, 6, 9, 24, 35, 75, 38, 65};
        int[] result = sort(array);
        for (int i :
                result) {
            System.out.print(i);
        }
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[j + 1]) {
                    //swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}