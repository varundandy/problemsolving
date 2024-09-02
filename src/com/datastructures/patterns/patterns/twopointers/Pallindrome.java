package com.datastructures.patterns.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Pallindrome {


    public static void main(String args[]) {
        String input[] = {"abba", "abcba", "river", "abcdefedcba"};
        List<Boolean> result = getPallindromeFunction.apply(input);
        System.out.println(Arrays.toString(result.toArray()));
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

    static Function<String[], List<Boolean>> getPallindromeFunction = input -> {
        return Arrays.asList(input).stream().map(entry -> isPallindromePredicate.test(entry)).collect(Collectors.toList());
    };
}
