package com.datastructures.problems;

import java.util.HashMap;
import java.util.Map;

/*
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

* */
public class ContainsDuplicate {

    public static void main(String args[])
    {
        int[] input ={1,2,3};
       boolean isDope = isDuplicate(input);
       System.out.print(isDope);

    }

    private static boolean isDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                return true;
            }
            else
            {
                map.put(nums[i],nums[i]);
            }
        }
        return false;
    }
}
