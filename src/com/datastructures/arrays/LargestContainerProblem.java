package com.datastructures.arrays;
/**
 * Shifting pointer technique.
 * This could have been done using brute force, with O(N^2) time complexity
 * This technique gets it done in one loop. O(N)
 */
public class LargestContainerProblem {

    public static void main(String args[]) {

        int inputs[] = {4, 8, 1, 2, 3, 9};
        int result = getMaxAreaOfContainer(inputs);
        System.out.println("Result: "+result);
    }

    private static Integer getMaxAreaOfContainer(int[] inputs) {

        int end = inputs.length - 1;
        int start = 0;
        int maxArea = 0;
        if(inputs.length < 2)
        {
            return maxArea;
        }
        while (start < end) {
            int area = Math.min(inputs[start], inputs[end]) * (end - start);
            if (area > maxArea) {
                maxArea = area;
            }
            if (inputs[start] < inputs[end]) {
                start++;
            } else
                end--;
        }
        return maxArea;
    }
}
