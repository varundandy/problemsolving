package com.datastructures.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pallindrome {

    public static void main(String[] args) {

        String inputArray[] = {"RACECAR", "KAYAK", "TART", "tattarrattat"};
        List<Boolean> resultList = isPallindromeList(inputArray);
        System.out.println(resultList);
    }

    private static List<Boolean> isPallindromeList(String[] inputArray) {
       return Arrays.asList(inputArray).stream().map(input -> isPallindromePredicate.test(input)).collect(Collectors.toList());
    }

    static Predicate<String> isPallindromePredicate = input -> {
        int i = 0;
        int j = input.length() - 1;
        while (i <= j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    };
}
