package com.datastructures.problems.twopointers;


import java.util.Arrays;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 * <p>
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {


    public static void main(String args[]) {

        int[] input = {1, 2, 3, 4, 6};
        int target = 6;
        int[] indices = getIndicesForTarget(input, target);
        System.out.println(Arrays.toString(indices));
    }

    private static int[] getIndicesForTarget(int[] input, int target) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int sum = input[left] + input[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }


}
