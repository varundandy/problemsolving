package com.datastructures.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Stack can be used to solve this but with more space complexity
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s a
 */
public class BackspaceProblem {

    public static void main(String args[]) {
        String left = "ab##";
        String right = "c#d#";
        boolean result = backspaceCompare(left, right);
        boolean result2 = backspaceCompareOptimized(left, right);
        System.out.println(result);
        System.out.println(result2);
    }

    private static boolean backspaceCompareOptimized(String left, String right) {
        int i = left.length() - 1;
        int j = right.length() - 1;
        int skipi = 0;
        int skipj = 0;

        while (i >= 0 || j >= 0) {
             while (i >= 0) {
                if (left.charAt(i) == '#') {
                    skipi++;
                    i--;
                } else if (skipi > 0) {
                    skipi--;
                    i--;
                } else break;
            }

            while (j >= 0) {
                if (right.charAt(j) == '#') {
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    skipj--;
                    j--;
                }else break;
            }

            if (i >= 0 && j >= 0 && left.charAt(i) != right.charAt(j)) {
                return false;
            }
            if ((i >= 0) !=  (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }


    public static boolean backspaceCompare(String s, String t) {

        Stack left = getFinalString(s);
        Stack right = getFinalString(t);
        if (left.equals(right)) {
            return true;
        }
        return false;
    }

    private static Stack getFinalString(String s) {
        char values[] = s.toCharArray();
        Stack finalValue = new Stack();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == '#' && !finalValue.empty()) {
                finalValue.pop();

            } else {
                finalValue.push(values[i]);
            }
        }
        return finalValue;
    }
}
