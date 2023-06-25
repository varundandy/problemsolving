package com.datastructures.cyclicsorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumbers {

    public static void main(String args[]) {

        int[] nums = {2, 4, 3, 1, 7, 6, 8, 2, 3, 4, 6, 7, 1};
        List<Integer> missingNums = FindAllMissingNumbers.find(nums);
        System.out.println(missingNums.toString());
    }

    private static List<Integer> find(int[] nums) {
        int i = 0;
        List<Integer> missingNumbers = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int j = 0; j < nums.length; j++) {
            if(j+1 !=nums[j])
            {
                missingNumbers.add(j+1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int source, int destination) {
        int temp = nums[destination];
        nums[destination] = nums[source];
        nums[source] = temp;
    }

}
