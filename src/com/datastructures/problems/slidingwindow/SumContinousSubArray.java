package com.datastructures.problems.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumContinousSubArray {

    public static void main(String args[]) {
        int[] inputArray = new int[]{2, 1, 5, 1, 3, 2};
        int[] inputArray2 = new int[]{2, 3, 4, 1, 5};
        int[] inputArray3 = new int[]{7, 3, 2, 6, 8, 5, 2, 4};
        int[] inputArray4 = new int[]{-1, 3, -2, 6, -1, 4, -1, 8, 2};
        List<int[]> inputs = new ArrayList<>();
        inputs.add(inputArray);
        inputs.add(inputArray2);
        inputs.add(inputArray3);
        inputs.add(inputArray4);


        List<int[]> averages = getMaximumSumSubArrays(3, inputs);
        for (int[] arr :
                averages) {
            System.out.println(Arrays.toString(arr));
        }
        List<Integer> maxSums = getMaximumSums(3,inputs);
        System.out.print(Arrays.toString(maxSums.toArray()));



        //int[] average = getMaximumSumSubArrayOptimized(3, inputArray3);
        //System.out.println(Arrays.toString(average));
        //System.out.println(Arrays.toString(average2));


    }

    private static List<int[]> getMaximumSumSubArrays(int k, List<int[]> inputs) {
        return inputs.stream().map(l -> getMaxSumSubArray(k, l).apply(l)).collect(Collectors.toList());
    }

    private static List<Integer> getMaximumSums(int k, List<int[]> inputs) {
        return inputs.stream().map(l -> getMaxSum(k, l).apply(l)).collect(Collectors.toList());
    }


    private static Function<int[], int[]> getMaxSumSubArray(int k, int[] inputArray) {
        return (x) -> {
            return getMaximumSumSubArrayOptimized(k, inputArray);
        };
    }

    private static Function<int[], Integer> getMaxSum(int k, int[] inputArray) {
        return (x) -> {
            return getMaximumSumOptimized(k, inputArray);
        };
    }

    /***
     * Sliding Window
     * T: O(N*k)
     * S: O(k)
     */
    private static int[] getMaximumSumSubArrayOptimized(int k, int[] inputArray) {
        int[] result = new int[k];
        int windowStart = 0;
        int maxSum = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            sum = sum + inputArray[windowEnd];
            if (windowEnd - windowStart + 1 == k) {
                if (sum > maxSum) {
                    maxSum = sum;
                    int start = windowStart;
                    int i = 0;
                    while (start <= windowEnd) {
                        result[i] = inputArray[start];
                        i++;
                        start++;
                    }
                }
                sum = sum - inputArray[windowStart];
                windowStart++;
            }
        }
        return result;
    }

    /***
     * Brute Force
     * T: O(N*K)
     * S: O(1)
     */
    private static int getMaximumSum(int k, int[] inputArray) {
       int maxSum = 0;
        for(int start = 0; start <= inputArray.length - k ;start++)
        {
            int sum = 0;
            for(int end = start; end < start + k; end++)
            {
                sum = sum + inputArray[end];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;

    }

    /***
     * Sliding Window
     * T: O(N)
     * S: O(1)
     */
    private static int getMaximumSumOptimized(int k, int[] inputArray) {
        int windowStart = 0;
        int maxSum = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            sum = sum + inputArray[windowEnd];
            if (windowEnd - windowStart + 1 == k) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                maxSum = Math.max(maxSum, sum);
                sum = sum - inputArray[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }


}
