package com.datastructures.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidPallindromeII {

    public static void main(String[] args) {

        String inputArray[] = {"RACEACAR", "KAYAK", "TARRT", "tattarrattat"};
        List<Boolean> resultList = isPallindromeList(inputArray);
        System.out.println(resultList);
    }

    static List<Boolean> isPallindromeList(String[] inputs) {
        return Arrays.stream(inputs).map(isPallindrome).collect(Collectors.toList());
    }
    static Function<String, Boolean> isPallindrome = input -> {
        int start = 0;
        int end = input.length() - 1;
        int counter = 0;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;

    };

    static Function<String, Boolean> isPallindromeButOne = input -> {

        int start = 0;
        int end = input.length() - 1;
        int counter = 0;
        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
              if(isPallindrome.apply(input.substring(start+1, end)) || isPallindrome.apply(input.substring(start, end-1))){
                  return true;
                } else{
                  return false;
              }
            } else {
                start++;
                end--;
            }
        }
        return true;
    };




}
