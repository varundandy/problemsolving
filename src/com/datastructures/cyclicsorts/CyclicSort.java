package com.datastructures.cyclicsorts;

import java.util.Arrays;

public class CyclicSort {


    public static void main(String args[]) {
        int[] input = { 3,3,2, 2, 1, 4, 6, 3, 2, 4};
        CyclicSort.sort(input);
        System.out.println(Arrays.toString(input));

    }

    private static void sort(int[] nums) {

        int i =0;
        while(i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] array, int source, int destination) {
        int temp = array[source];
        array[source] = array[destination];
        array[destination] = temp;
    }
}
