package com.datastructures.problems.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithSameLettersAfterReplacement {


    public static void main(String args[]) {
        String input = "aabccbb";
        int k = 2;
        int val = compute(input, k);
        System.out.println(val);
    }

    private static int compute(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
            //aabcabc k =2 -> 5
            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

}
