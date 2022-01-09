package com.datastructures.problems.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 * Example 4:
 * <p>
 * Input: String="cbbebi", K=10
 * Output: 6
 * Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */
public class LongestSubstringWIthDistinctCharacters {


    public static void main(String[] args) {

        String input = "araaci";
        int k = 1;
        int result = getLongestSubStringWithDistinctCharacaters(k, input);
        System.out.println(result);

    }

    /**
     * T:O(2N)~O(N)
     * S:O(k+1)
     * **/
    private static int getLongestSubStringWithDistinctCharacaters(int k, String input) {

        int windowStart = 0;
        int maxSize = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = input.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.getOrDefault(leftChar, 0) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
        }
        return maxSize;
    }
}
