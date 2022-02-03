package com.datastructures.problems.slidingwindow;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * Given a string, find the length of the longest substring, which has all distinct characters.
 *
 * Example 1:
 *
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 * Example 2:
 *
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring with distinct characters is "ab".
 * Example 3:
 *
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 *
 */
public class LongestSubStringDistinctCharacters {

    public static void main(String args[]) {

        List<String> inputs = new ArrayList<>();
        inputs.add("aabccbb");
        inputs.add("abbbb");
        inputs.add("abccde");
        //int result = getLongestSubStringWithDistinctChars(input);
        List<Integer> results = getLongestSubStringsWithDistinctChars(inputs);
        System.out.println(Arrays.toString(results.toArray()));


    }

    private static List<Integer> getLongestSubStringsWithDistinctChars(List<String> inputs) {

        return inputs.stream().map(l -> getLongestSubStringFunction(l).apply(l)).collect(Collectors.toList());
    }

    private static Function<String, Integer> getLongestSubStringFunction(String input) {
        return (x) -> {
            return getLongestSubStringWithDistinctChars2(input);
        };
    }

    private static int getLongestSubStringWithDistinctChars(String input) {
        if (input.length() < 1) {
            return -1;
        }
        int maxLength = 0;
        int windowStart = 0;
        Set<Character> charVisited = new HashSet<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            if (!charVisited.contains(rightChar)) {
                charVisited.add(rightChar);
            } else {
                maxLength = Math.max(maxLength, charVisited.size());
                charVisited = new HashSet<>();
                charVisited.add(input.charAt(windowEnd));
                windowStart = windowEnd;
            }
        }
        return maxLength;

    }


    /**
     * T: O(N)
     * S: O(k) where K<=N
     *
     * */
    private static int getLongestSubStringWithDistinctChars2(String input) {
        if (input.length() < 1) {
            return -1;
        }
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> charVisited = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            // get the character on the right
            char rightChar = input.charAt(windowEnd);
            if (charVisited.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charVisited.get(rightChar) + 1);
            }
            charVisited.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;

    }
}
