package com.datastructures.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree, you are given two baskets,
 * and your goal is to put maximum number of fruits in each basket. The only restriction is that
 * each basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick one fruit from each tree until you cannot, i.e.,
 * you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitsIntoBasket {

    public static void main(String args[]) {
        char[] fruits = new char[]{'A', 'B', 'C', 'A', 'C'};
        int noOfBaskets = 2;
        int result = getMaxNumberOfFruits(noOfBaskets, fruits);
        System.out.println(result);
    }

    /**
     * T: O(N + ~N) ~ O(2N) ~ O(N)
     * S: O(basketSize + 1 )
     * */
    private static int getMaxNumberOfFruits(int noOfBaskets, char[] fruits) {
        // given no of baskets are two, there can be at most 2 unique char in the substring.
        if (fruits.length < 2) {
            return -1;
        }
        int maxSize = 0;
        int windowStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            char rightChar = fruits[windowEnd];
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > noOfBaskets) {
                char leftChar = fruits[windowStart];
                charFrequencyMap.put(leftChar, charFrequencyMap.getOrDefault(leftChar, 0) - 1);
                if (charFrequencyMap.get(leftChar) < 1) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
        }
        return maxSize;
    }
}
