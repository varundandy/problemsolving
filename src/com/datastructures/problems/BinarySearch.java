package com.datastructures.problems;

public class BinarySearch {

    public static void main(String args[]) {
        int nums[] = {-1,0,3,5,9,12};
        int target = 5;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int index = binarySearch(nums, startIndex, endIndex, target);
        System.out.print(index);
    }

    private static int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int index = 0;
        int middle = startIndex + (endIndex - startIndex) / 2;
        if(endIndex>=startIndex) {

            if (target == nums[middle]) {
                return  middle;
            }

            if (target > nums[middle]) {
                return binarySearch(nums, middle+1, endIndex, target);
            }
                return binarySearch(nums, startIndex, middle-1, target);

        }
        return -1;
    }

    public static int binarySearch2(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch2(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch2(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
