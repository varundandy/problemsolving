package com.datastructures.searching;

public class BinarySearch {


    public static void main(String args[]) {

        int[] input = {1, 2, 5, 7, 9, 17, 21, 30};
        int index = binarySearch(input, 30);
        System.out.print(index);

    }

    private static int binarySearch(int[] arr, int value) {

        int lb = 0;
        int ub = arr.length - 1;

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        return -1;
    }
}
