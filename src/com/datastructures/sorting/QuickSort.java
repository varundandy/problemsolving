package com.datastructures.sorting;

/**
 *
 * Time Complexity : nO(log n)
 * Space Complexity: O(1)
 *
 */
public class QuickSort {

    public static void main(String args[]) {

        int[] array = {41, 5, 14, 6, 9, 24, 35, 75, 38, 65};
        int[] result = quickSort(array, 0, array.length - 1);
        for (int i :
                result) {
            System.out.println(i);
        }
    }

    public static int[] quickSort(int[] array, int lb, int ub) {
        if (lb < ub) {
            int pivot = partition(array, lb, ub);
            quickSort(array, lb, pivot - 1);
            quickSort(array, pivot + 1, ub);

        }
        return array;
    }

   /* private static int partition(int[] array, int lb, int ub) {
        int pivot = array[lb];
        int start = lb;
        int end = ub;
        while (start < end) {
            while (array[start] >= pivot) {
                start++;
            }
            while (array[end] < pivot) {
                end--;
            }
            if (start >= end) {
                swap(array, start, end);
            }
        }
        swap(array, lb, end);

        return end;
    }*/

    public static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
