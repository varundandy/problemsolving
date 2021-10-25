package com.datastructures.problems;

/*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
*
*/
public class MoveZeros {

    public static void main(String args[]) {
        int[] input = {0, 1, 0, 3, 12};
        int result[] = moveZeros(input);
        for (int i : result) {
            System.out.print(i);
        }

    }

    private static int[] moveZeros(int[] nums) {
        //int[] input = {0, 1, 0, 3, 12};
        int length = nums.length;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
               nums[k++] = nums[i];
            }
        }
        while(k<nums.length)
        {
            nums[k] = 0;
            k++;
        }
        return nums;
    }
}
