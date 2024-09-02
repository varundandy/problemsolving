package com.datastructures.patterns.slidingwindow;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {
        String[] str1 = {
                "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "adeq", "kzed", "css", "la", "ab"
        };

        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static String minWindow(String s, String t) {

        int start = 0;
        int end = 0;
        String minSubsequence = "";
        int tItr = 0;
        int sItr = 0;
        while (tItr < t.length()) {
            if (s.charAt(sItr) == s.charAt(tItr)) {
                if (tItr == 0) {
                    start = sItr;
                } else if (tItr == t.length() - 1) {
                    end = sItr;
                    if (minSubsequence.length() > end - start) {
                        minSubsequence = s.substring(start, end);
                    }
                }
                sItr++;
                tItr++;
            } else {
                sItr++;
            }
        }
        // your code will replace the following placeholder return statement
        return minSubsequence ;
    }


}
