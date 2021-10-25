package com.datastructures.problems;

/*
* Given an array, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*
* */
public class RotateArray {
    public static void main(String args[]) {
        int[] input = {-1,-100,3,99};
        int steps = 4;
        int result[] = rotate(input, steps);
        for (int i : result) {
            System.out.print(i);
        }
    }

    private static int[] rotate(int[] nums, int k) {
        int length = nums.length;
        if(length==1 || nums==null || k<0){
            return null;
        }

        int[] sublist = new int[length]; //can hold {1,2,3,4}
        for (int i = 0; i <= k; i++) {
            sublist[i] = nums[i];
            nums[i] = 0;
        }
        int nonNegativeFound = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[nonNegativeFound++] = nums[i]; ///nums = {5,6,7}
            }
        }
        int i = 0;
        for (int j = nonNegativeFound; j < length; j++) {
            nums[j] = sublist[i];
            i++;
        }
        return nums;
    }
}
