package com.datastructures.strings;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PallindromeProblem {

    public static void main(String args[]) {
        List<String> inputs = getInputList("A man, a plan, a canal: Panama", "aabbaa", "", "abc", "a", "raceacar");
        List<Boolean> results = isApallindromeList(inputs, isAPallindrome());
        List<Boolean> results2 = isApallindromeList(inputs, isAPallindrome2());
        List<Boolean> results3 = isApallindromeList(inputs, isAPallindrome3());
        System.out.println(Arrays.toString(results.toArray()));
        System.out.println(Arrays.toString(results2.toArray()));
        System.out.println(Arrays.toString(results3.toArray()));
    }

    private static List<String> getInputList(String... inputList) {
        List<String> inputs = new ArrayList<>();
        for(String i : inputList) {
            inputs.add(i);
        }
        return inputs;
    }

    private static List<Boolean> isApallindromeList(List<String> inputs, Function<String, Boolean> aPallindrome) {
        return inputs.stream().map(l -> replaceSpecialCharWithLowerCase().apply(l)).map(l -> aPallindrome.apply(l)).collect(Collectors.toList());
    }

    private static Function<String, String> replaceSpecialCharWithLowerCase() {
        return x -> x.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
    }

    /**
     * T: O(N)
     * S: O(1)
     * */
    private static Function<String, Boolean> isAPallindrome() {
        return x -> {
            int i = 0;
            int j = x.length() - 1;
            while (i <= j) {
                if (x.charAt(i) != x.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        };
    }

    /**
     * T: O(N)
     * S: O(1)
     * */
    private static Function<String, Boolean> isAPallindrome2() {
        return x -> {
            int i = 0;
            int j = 0;
            if (x.length() % 2 == 0) {
                i = (x.length() - 1) / 2;
                j = i + 1;
            } else {
                i = j = (x.length() - 1 )/ 2;
            }

            while (i >= 0 && j <= x.length() - 1) {
                if (x.charAt(i) != x.charAt(j)) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        };
    }

    /**
     * T: O(N)
     * S: O(N)
     * */
    private static Function<String, Boolean> isAPallindrome3() {
        return x -> {
            char yArray[] = new char[x.length()];
            int j = 0;
            for (int i = x.length() - 1; i >= 0; i--)
            {
                yArray[j] = x.charAt(i);
                j++;
            }
            String y = new String(yArray);
            return x.equals(y);
        };
    }

    private static boolean isApallindrome(String input) {
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
    }
}