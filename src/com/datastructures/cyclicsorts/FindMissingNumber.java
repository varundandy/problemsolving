package com.datastructures.cyclicsorts;

public class FindMissingNumber {

    public static void main(String arg[]) {
        int[] input = {6, 4, 3, 2, 1, 0};
        int missingNumber = FindMissingNumber.find(input);
        System.out.println(missingNumber);


    }

    private static int find(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else
                i++;
        }
        for(int j =0; j < nums.length; j++)
        {
            if(j !=nums[j])
            {
                return j;
            }
        }
        return -1;
    }

    private static void swap(int[] input, int source, int destination) {
        int temp = input[source];
        input[source] = input[destination];
        input[destination] = temp;
    }

}
