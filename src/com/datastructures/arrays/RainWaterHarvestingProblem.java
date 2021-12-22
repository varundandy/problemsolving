package com.datastructures.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class RainWaterHarvestingProblem {

    public static void main(String args[]) {

        int inputs[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int inputs2[] = {0,2,0,4,0,2,4};
        int result = getAreaOfWaterTrapped(inputs2);
        int result2 = getAreaOfWaterTrappedOptimized(inputs2);
        System.out.println(result);
        System.out.println(result2);

    }

    private static int getAreaOfWaterTrappedOptimized(int[] heights) {
        int left = 0, right = heights.length - 1, totalWater = 0, maxLeft = 0, maxRight = 0;

        while(left < right) {
            if(heights[left] <= heights[right]) {
                if(heights[left] >= maxLeft) {
                    maxLeft = heights[left];
                } else {
                    totalWater += maxLeft - heights[left];
                }
                left++;
            } else {
                if(heights[right] >= maxRight) {
                    maxRight = heights[right];
                } else {
                    totalWater += maxRight - heights[right];
                }

                right--;
            }
        }

        return totalWater;
    }

    private static int getAreaOfWaterTrapped(int[] inputs) {
        int area = 0;
        // Min(left, right) - currentHeight
        for (int i = 0; i < inputs.length; i++) {
            int maxLeft = 0;
            int maxRight = 0;
            int leftp = i;
            int rightp = i;
            while (leftp != 0) {
                leftp--;
                maxLeft = Math.max(maxLeft, inputs[leftp]);
            }
            while (rightp < inputs.length) {
                maxRight = Math.max(maxRight, inputs[rightp]);
                rightp++;
            }
            int currentWater = Math.min(maxLeft, maxRight) - inputs[i];
            if (currentWater >= 0) {
                area += currentWater;
            }
        }
        return area;
    }
}
