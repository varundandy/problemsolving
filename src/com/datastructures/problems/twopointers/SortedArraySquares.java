package com.datastructures.problems.twopointers;


import java.util.Arrays;
import java.util.Collections;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 * <p>
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SortedArraySquares {

    public static void main(String args[]) {
        int[] input = {-2, -1, 0, 2, 3};
        int[] result = getSortedSquaredArray(input);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getSortedSquaredArray(int[] input) {
        int left = 0;
        int right = input.length - 1;
        int resultSquarePosition = input.length - 1;
        int[] result = new int[input.length];

        while (left < right) {
            int leftSquare = input[left] * input[left];
            int rightSquare = input[right] * input[right];
            if (leftSquare > rightSquare) {
                result[resultSquarePosition--] = leftSquare;
                left++;
            } else {
                result[resultSquarePosition--] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
