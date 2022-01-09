package com.datastructures.problems.slidingwindow;

import java.util.Arrays;

/**
 * Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class KSubArrayProblem {


    public static void main(String args[]) {
        int[] inputArray = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] average = getAverage(5, inputArray);
        double[] average2 = getAverageOptimized(5, inputArray);
        System.out.println(Arrays.toString(average));
        System.out.println(Arrays.toString(average2));
    }


    /**
     * T: O(N*K)
     * S: O(N-k+1)
     * */
    private static double[] getAverage(int k, int[] inputArray) {
        double result[] = new double[inputArray.length -k + 1];
        for (int i = 0; i <= inputArray.length - k; i++) {
        double sum = 0;
            for(int j = i; j < i+k; j++)
            {
                sum = sum + inputArray[j];
            }
            result[i] = sum/k;
        }
        return result;
    }

    /**
     * T: O(N)
     * S: O(N-k) ~ O(N) ??
     * */
    private static double[] getAverageOptimized(int k, int[] inputArray) {
        double result[] = new double[inputArray.length -k + 1];
     // int i = 0;
       // int j = i + k;
        double sum = 0.0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < inputArray.length; windowEnd++)
        {
            sum = sum + inputArray[windowEnd];
            if(windowEnd - windowStart + 1 == k)
            {
                double average = sum/k; // getting the average
                result[windowStart] = average;
                sum = sum - inputArray[windowStart];
                windowStart++;
            }
        }
        return result;
    }

}
