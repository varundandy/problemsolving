package com.datastructures.problems.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * Example 2:
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * Example 3:
 * <p>
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
 * or [1, 1, 6].
 */
public class SmallestSubArrayGreaterThan {

    public static void main(String args[]) {
        int[] inputArray = new int[]{2, 1, 5, 2, 3, 2};
        int[] inputArray2 = new int[]{2, 1, 5, 2, 8};
        int[] inputArray3 = new int[]{3, 4, 1, 1, 6};
        List<int[]> inputs = new ArrayList<>();
        inputs.add(inputArray);
        inputs.add(inputArray2);
        inputs.add(inputArray3);
        List<Integer> values = getSmallestSubArrayLength(7, inputs);
        System.out.print(Arrays.toString(values.toArray()));


    }

    private static List<Integer> getSmallestSubArrayLength(int k, List<int[]> inputs) {

        return inputs.stream().map(l -> getSmallestSubArraySize(k, l).apply(l)).collect(Collectors.toList());
    }

    /**
     *
     * T: O(N)
     * S: O(1)
     * */
    private static Function<int[], Integer> getSmallestSubArraySize(int k, int[] input) {

        return (x) -> {
            int smallestArraySize = Integer.MAX_VALUE;
            int windowStart = 0;
            int sum = 0;
            for(int windowEnd = 0; windowEnd < input.length; windowEnd++)
            {
                sum = sum + input[windowEnd];
                while(sum >= k)
                {
                     int size = windowEnd - windowStart + 1;
                     smallestArraySize = Math.min(smallestArraySize, size);
                     sum = sum - input[windowStart];
                     windowStart++;
                }
            }
            return smallestArraySize;
        };
    }
}
