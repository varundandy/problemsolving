package com.datastructures.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SumOfThreeValues {

    public static void main(String[] args) {
        int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
                {-1, 2, 1, -4, 5, -3},
                {2, 3, 4, 1, 7, 9},
                {1, -1, 0},
                {2, 4, 2, 7, 6, 3, 1}};
        int[] targetList = {10, 7, 20, -1, 8};
        List<Boolean> resultList = sumOfThreeValuesList(numsList, targetList);
        System.out.println(resultList.toString());
    }

    private static List<Boolean> sumOfThreeValuesList(int[][] numsList, int[] targetList) {
        List<Boolean> resultList = new ArrayList<>();
        IntStream.range(0, numsList.length).forEach(idx -> {
            resultList.add(sumOfThreeValuesPredicate.test(numsList[idx], targetList[idx]));
        });
        return resultList;
    }

    static BiPredicate<int[], Integer> sumOfThreeValuesPredicate = (array, target) -> {

        int low = 0;
        int high = array.length - 1;
        int sum = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            low = i + 1;
            high = array.length - 1;
            int anchor = array[i];
            while (low < high) {
                sum = anchor + array[low] + array[high];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                }
            }
        }
        return false;
    };
}
