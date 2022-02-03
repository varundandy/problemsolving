package com.datastructures.problems.twopointers;


/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 * <p>
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {


    public static void main(String args[]) {
        int[] input = {2, 3, 3, 3, 6, 9, 9};
        int result = getUniqueArrayLength(input);
        System.out.println(result);

    }

    private static int getUniqueArrayLength(int[] input) {

        int noOfUniqueItems = 1;
        int i = 1;
        while (i < input.length - 1) {
            if(input[noOfUniqueItems-1] != input[i])
            {
                input[noOfUniqueItems] = input[i];
                noOfUniqueItems++;
            }
            i++;
        }
        return noOfUniqueItems;
    }

}
