package com.datastructures.sorting;

import java.util.Arrays;

public class KLargestElement {


    public static void main(String args[]) {
        int[] input = {7, 4, 5, 1, 9, 8, 4, 10, 6};
        System.out.println("Before: " + Arrays.toString(input));
        input = quickSort(input, 0, input.length - 1);
        System.out.println("After Sort: " + Arrays.toString(input));
        int k = getKLargestElement(input, 3);
        System.out.println(1);

    }

    private static int getKLargestElement(int[] input, int i) {
        return input[input.length - i];
    }

    private static int[] quickSort(int[] input, int lb, int ub) {
        if (lb < ub) {
            int pivot = partition(input, lb, ub);
            quickSort(input, lb, pivot-1);
            quickSort(input, pivot +1, ub);
        }
        return input;
    }

    private static int partition(int[] input, int lb, int ub) {

        //choose the last element as pivot
        int pivot = input[ub];

        // we will use two pointers here
        //start with init i as -1
        int i = lb - 1;
        for (int j = lb; j <= ub-1; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, ub);
        return i+1;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
