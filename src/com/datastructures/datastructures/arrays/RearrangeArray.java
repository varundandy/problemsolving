package com.datastructures.datastructures.arrays;

import java.util.Arrays;

public class RearrangeArray {

    public static void main(String args[]) {
        int[][] inputArray = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {11, 22, 33, 44, 55, 66, 77, 88},
                {1, 2, 4, 8, 16, 32, 64, 128, 512, 1024},
                {3, 3, 5, 5, 7, 7, 9, 9, 11, 11, 13, 13},
                {100, 233, 544, 753, 864, 935, 1933, 2342}
        };

        for (int i = 0; i < inputArray.length; ++i) {
            System.out.print((i + 1) + ".\tOriginal array: ");
            System.out.print(Arrays.toString(inputArray[i]));
            System.out.print("\n\tRearranged array: ");
            int[] rearranged = rearrangeArray(inputArray[i]);
            System.out.print(Arrays.toString(rearranged));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }

    }

    public static int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int mid = n / 2;
        int index = 0;

        for (int i = 0; i < mid; i++) {

            result[index++] = nums[n - (i + 1 )];
            result[index++] = nums[i];
        }

        if (n % 2 == 1) {
            result[index] = nums[mid];
        }

        // Replace this placeholder return statement with your code
        return result;
    }

}
