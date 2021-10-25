package com.datastructures.problems;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 * <p>
 * Input: nums = [1], target = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 **/
public class SearchInsertPosition {

    public static void main(String args[]) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int result = searchInsertPosition(nums, target);
        System.out.println(result);
    }

    private static int searchInsertPosition(int[] nums, int target) {
        int startIndex = 0;
        int ans = 0;
        int endIndex = nums.length-1;
        while (endIndex >= startIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (nums[mid] < target) {
                startIndex = mid + 1;
                ans = mid + 1;
            } else {
                endIndex = mid - 1;
                ans = mid -1;
            }
        }

        return ans;
    }
}
