package com.datastructures.patterns.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SumOfThree {

    public static void main(String args[]) {

        int[] input = {3, 7, 1, 2, 8, 4, 5};
        int[] input2 = {-1, 2, 1, 4};
        int[] input3 = {-1, 2, 1, 4, -2};
        int[] input4 = {1,-1,0};
        int[] input5 = {3,7,1,2,8,4,5};
        int[] input6 = {3,7,1,2,8,4,5};
        int[] input7 = {-1,2,1,-4,5,-3};
        int[] input8 = {-1,2,1,-4,5,-3};
        int target = 11;
        int target2 = 1;
        int target3 = 1;
        int target4 = -1;
        int target5 = 10;
        int target6 = 21;
        int target7 = -8;
        int target8 = 0;
        Object[][] multiDimensionalArray = {
                {input, target},
                {input2, target2},
                {input3, target3},
                {input4, target4},
                {input5, target5},
                {input6, target6},
                {input7, target7},
                {input8, target8}
        };
        List<Boolean> result = findSumOfThreeFunction.apply(multiDimensionalArray);
        System.out.println(Arrays.toString(result.toArray()));
    }



    private static Boolean findSumOfThree(int[] input, int target) {
        int low, high, sum;
        Arrays.sort(input);
        System.out.println("Input: "+ Arrays.toString(input) + " target: " + target);
        for(int i = 0; i < input.length - 2;i++) {
            low = i+ 1;
            high = input.length - 1;
            while (low < high) {
                sum = input[i] + input[low] + input[high];
                if (sum == target) {
                    return true;
                }
                if (sum < target) {
                    low = low + 1;
                } else {
                    high = high - 1;
                }
            }
        }
        return false;
    }

    // Define the Predicate
    static Predicate<Object[]> sumOfThreePredicate = arr -> {
        int[] numbers = (int[]) arr[0];
        int targetValue = (int) arr[1];
        return findSumOfThree(numbers, targetValue);
    };


    static Function<Object[][], List<Boolean>> findSumOfThreeFunction = inputs -> {
        return Arrays.stream(inputs).map(input -> sumOfThreePredicate.test(input)).collect(Collectors.toList());
    };

}
