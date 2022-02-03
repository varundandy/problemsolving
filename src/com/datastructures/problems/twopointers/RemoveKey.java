package com.datastructures.problems.twopointers;



/**
 *
 * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 *
 * Example 1:
 *
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 * Example 2:
 *
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 *
 *
 * */
public class RemoveKey {


    public static void main(String args[])
    {
        int[] input = {2, 11, 2, 2, 1};
        int target = 3;
        int result = removeKey(input, target);
        System.out.println(result);

    }

    private static int removeKey(int[] input, int target) {
        int remainingKeys = 0;
        int i = 0;
        while(i < input.length)
        {
            if(input[i]!=target)
            {
                input[remainingKeys] = input[i];
                remainingKeys++;
            }
            i++;
        }
        return remainingKeys;



    }
}
