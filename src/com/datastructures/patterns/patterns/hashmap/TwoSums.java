package com.datastructures.patterns.patterns.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String args[]) {

        int[] input = {1, 5, 4, 3, 6};
        int target = 7;
        int[][] result = checkPairForTargetSum(input, target);
        Arrays.stream(result)               // Stream over rows (1D arrays)
                .forEach(row -> {          // For each row
                    Arrays.stream(row)     // Stream over elements in the row
                            .forEach(num -> System.out.print(num + " "));
                    System.out.println();  // Move to the next line after each row
                });
    }

    public static int[][] checkPairForTargetSum(int[] input, int target) {
        int columns = input.length % 2 == 0 ? input.length / 2 - 1 : input.length / 2;
        
        int[][] result = new int[2][columns];
        Map<Integer, Integer> map = new HashMap<>();
        int row = 0;
        for (int i = 0; i < input.length; i++) {
            int temp = target - input[i];
            if (map.containsKey(input[i])) {
                result[row][0] = input[map.get(input[i])];
                result[row][1] = input[i];
                row++;
            } else {
                map.put(temp, i);
            }
        }
        return result;
    }
}
