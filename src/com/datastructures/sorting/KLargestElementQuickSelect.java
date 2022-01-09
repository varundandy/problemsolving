package com.datastructures.sorting;

import java.util.Arrays;

public class KLargestElementQuickSelect {


    public static void main(String args[]) {
        int[] input = {7, 4, 5, 1, 9, 8, 4, 10, 6};
        System.out.println("Before: " + Arrays.toString(input));
        // find kth pargest element
        int k = 3;
        int indexToFind = input.length - k;
        int result = quickSelect(input, 0, input.length - 1, indexToFind);
        System.out.println(result);

    }

    private static int getKLargestElement(int[] input, int i) {
        return input[input.length - i];
    }

    private static int quickSelect(int[] input, int lb, int ub, int indexToFind) {
            int pivot = partition(input, lb, ub);
            if (pivot == indexToFind) {
                return input[indexToFind];
            } else if (indexToFind > pivot) {
                return quickSelect(input, pivot + 1, ub, indexToFind);
            } else {
                return quickSelect(input, lb, pivot - 1, indexToFind);
            }
    }

    private static int partition(int[] input, int lb, int ub) {

        //choose the last element as pivot
        int pivot = input[ub];

        // we will use two pointers here
        //start with init i as -1
        int i = lb - 1;
        for (int j = lb; j <= ub - 1; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, ub);
        return i + 1;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
