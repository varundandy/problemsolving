package com.datastructures.datastructures.arrays;

import java.util.Arrays;

public class MaximumSubArray {

    public static void main(String args[]){
        int[][] inputs = {
                {1, 2, 2, 3, 3, 1, 4},
                {2, 2, 1},
                {4, 1, 2, 1, 2},
                {-4, -1, -2, -1, -2},
                {-4, 2, -5, 1, 2, 3, 6, -5, 1},
                {25}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tMaximum Sum: " + findMaxSumSubArray(inputs[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }

    }

    public static int findMaxSumSubArray(int[] nums) {

        int leftIndex = 0;
        int rightIndex = leftIndex + 1;
        int maxSum = 0;
        if(nums.length == 0){
            return maxSum;
        }
      //

        // Replace this placeholder return statement with your code
        return 0;
    }
}
