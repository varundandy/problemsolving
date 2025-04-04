package com.datastructures.patterns.patterns.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find four elements in an array where a + b = c + d
 */
public class MatchingSumFourElements {

    public static void main(String args[]) {

        

    }

    public static int[] matchingSumFourElements(int[] input) {
        int[] result = new int[4];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {

            for (int j = i + 1; j < input.length; j++) {
                int sum = input[i] + input[j];
                if (map.containsKey(sum)) {
                    List<Integer> initValues = map.get(sum);
                    initValues.add(input[i]);
                    initValues.add(input[j]);
                } else {
                    
                }


            }

        }
        return result;

    }

}
