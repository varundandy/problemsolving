package com.datastructures.searching;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class PositionOfElementsInSortedArray {

    public static void main(String args[]) {
        int[] input = {1, 2, 3, 4, 4, 4, 5, 5, 6, 7, 8, 10};
        int[] result = searchIndex(input, 4);
        int[] result2 = searchIndexOptimized(input, 4);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    /**
     * This solution the the two pointers will scan through the items on both side making it O(n)
     * hence not a really optimized solution
     */
    private static int[] searchIndex(int[] arr, int value) {

        int[] result = {-1, -1};
        int lb = 0;
        int ub = arr.length - 1;

        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (arr[mid] == value) {
                int lp = mid, rp = mid;
                while (arr[lp] == value) {
                    lp--;
                }
                while (arr[rp] == value) {
                    rp++;
                }
                return new int[]{lp + 1, rp - 1};
            } else if (value > arr[mid]) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * This solution the the two pointers will scan through the items on both side making it O(n)
     * hence not a really optimized solution
     * T: O(N)
     * S: O(1)
     */
    private static int binarySearch(int[] arr, int value, int lb, int ub) {
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

    /**
     * T: O(log n)
     * S: O(1)
     * */
    public static int[] searchIndexOptimized(int[] array, int target) {
        if (array.length < 1) {
            return new int[]{-1, -1};
        }
        int firstPosition = binarySearch(array, target, 0, array.length - 1);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int start = firstPosition;
        int end = firstPosition;
        int temp1 = 0, temp2 = 0;

        while (start != -1) {
            temp1 = start;
            start = binarySearch(array, target, 0, start - 1);
        }
        start = temp1;
        while (end != -1) {
            temp2 = end;
            end = binarySearch(array, target, end + 1, array.length - 1);
        }
        end = temp2;
        return new int[]{start, end};
    }
}
