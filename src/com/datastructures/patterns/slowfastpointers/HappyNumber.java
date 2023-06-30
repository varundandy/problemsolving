package com.datastructures.patterns.slowfastpointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class HappyNumber {

    public static void main(String[] args) {

        int n = 2;
        Integer[] listOfNumbers = {1, 5, 19, 25, 7};
        List<Boolean> resultList = areHappyNumbers(listOfNumbers);
        boolean result = isHappyNumber.apply(n);
        System.out.println(resultList);
    }

    private static List<Boolean> areHappyNumbers(Integer[] listOfNumbers) {
        return Arrays.asList(listOfNumbers).stream().map(isHappyNumber).collect(Collectors.toList());
    }


    static Function<Integer, Boolean> isHappyNumber = n -> {
        int slow = n;
        int fast = getSumOfSquareOfDigits(getSumOfSquareOfDigits(n));
        while (fast != 1 && slow != fast) {
            slow = getSumOfSquareOfDigits(slow);
            fast = getSumOfSquareOfDigits(getSumOfSquareOfDigits(fast));
        }
        return fast == 1;
    };

    static Integer getSumOfSquareOfDigits(Integer number) {
        int totalSum = 0;
       // List<Integer> listOfDigits = new ArrayList<>();
        while (number != 0) {
            int digit = number % 10;
            totalSum += (Math.pow(digit, 2));
            number = number / 10;
        }
        return totalSum;
       // return listOfDigits.stream().map(x -> x * x).reduce(0, Integer::sum);
    }
}
