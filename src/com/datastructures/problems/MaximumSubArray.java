package com.datastructures.problems;
/*
*
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104

*Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
* */

public class MaximumSubArray {
    public static void main(String args[]) {
        int[] arr = {-2, -1, 4 , -1, 2};

        int result = maxSum3(arr);
        System.out.println(result);

    }

    private static int finMaxSubArray(int[] arr) {
        int total = 0;
        int maxValue = 0;
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
            if (total < 0) {
                total = 0;
            }
            if (total > maxValue) {
                maxValue = total;
            }
        }
        return maxValue;
    }

    public static int maxSum(int[] nums) {
        int n = nums.length;
        int[] maxSubArray = new int[n];
        maxSubArray[0] = nums[0];
        int max = maxSubArray[0];

        for (int i = 1; i < n; i++) {
            maxSubArray[i] = nums[i] + (maxSubArray[i - 1] > 0 ? maxSubArray[i - 1] : 0);
            max = Math.max(max, maxSubArray[i]);
        }

        return max;
    }

    public static int maxSum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = 0;
        int ans = Integer.MIN_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            ans = Math.max(ans, preSum - minSum);
            minSum = Math.min(minSum, preSum);
        }
        return ans;

    }

    public static int maxSum3(int[] nums)
    {
        //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        int max = nums[0];
        int current = nums[0];

        for(int i =1;i<nums.length;i++){
            if(current<0){
                current = nums[i];
            }else{
                current = current +nums[i];
            }
            max = Math.max(current,max);

        }
        return max;
    }
}
