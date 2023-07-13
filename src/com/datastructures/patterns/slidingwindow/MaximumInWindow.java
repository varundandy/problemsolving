package com.datastructures.patterns.slidingwindow;

import java.util.Arrays;
import java.util.stream.Stream;

/*
* Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.
* */
public class MaximumInWindow {

    public static void main(String[] args) {
        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 18};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {
      int start = 0;
      int end = w-1;
      int count = 0;
      if(nums.length < w){
          int max = getMaxFromWindow(nums, start, nums.length-1);
          return new int[]{max};
      }
      int[] result = new int[nums.length - w + 1];
       while(end <= nums.length - 1){
           int max = getMaxFromWindow(nums, start, end);
           result[count] = max;
           count++;
           start++;
           end++;
       }
       return result;
    }

    private static int getMaxFromWindow(int[] nums, int start, int end) {
        int max = 0;
        for(int i = start; i <= end;i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }
}
