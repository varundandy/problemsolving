package com.datastructures.patterns.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ReverseString {

    public static void main(String args[]) {

        List<String> stringsToReverse = Arrays.asList(
                "Hello World",
                "a   string   with   multiple   spaces",
                "Case Sensitive Test 1234",
                "a 1 b 2 c 3 d 4 e 5",
                "     trailing spaces",
                "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


    public static void reverseString(char[] stringToReverse, int start, int end) {
        while (start < end) {
            char temp = stringToReverse[start];
            stringToReverse[start] = stringToReverse[end];
            stringToReverse[end] = temp;
            start++;
            end--;
        }
    }


    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();
        char[] reversedSentenceChar = sentence.toCharArray();
        reverseString(reversedSentenceChar, 0, reversedSentenceChar.length - 1);
        int length = reversedSentenceChar.length - 1;
        for (int start = 0, end = 0; end <= length; end++) {
            if (end == length || reversedSentenceChar[end] == ' ') {
                int endIdx = (end == length) ? end : end - 1;
                reverseString(reversedSentenceChar, start, endIdx);
                start = end + 1;
            }
        }
        return new String(reversedSentenceChar);
    }
}
