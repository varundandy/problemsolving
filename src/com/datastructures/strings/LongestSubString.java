package com.datastructures.strings;

import java.util.*;

public class LongestSubString {

    public static void main(String args[]) {
        String input = "abba";
        int length = longestSubStringCount(input);
        int length2 = longestSubStringCountOptimized(input);
        System.out.println(length);
        System.out.println(length2);

    }

    /**
     * T: O(N^2)
     * S: O(N)
     */
    private static int longestSubStringCount(String input) {
        int maxLength = 0;
        List<Character> visitedNodes = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                if (!visitedNodes.contains(input.charAt(j))) {
                    visitedNodes.add(input.charAt(j));
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, visitedNodes.size());
            visitedNodes.clear();
        }
        return maxLength;
    }

    private static int longestSubStringCountOptimized(String input) {
        if (input.length() <= 1) {
            return input.length();
        }
        //"abcdbada";
        int maxLength = 0;
        int i = 0, j = i;
        Map<Character, Integer> seen = new HashMap<>();
        while (j < input.length()) {
            char current = input.charAt(j);
            Integer prevSeenChar = seen.get(current);

            if(Objects.nonNull(prevSeenChar) && prevSeenChar >= i) {
                i = prevSeenChar + 1;
            }
            seen.put(current, j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}