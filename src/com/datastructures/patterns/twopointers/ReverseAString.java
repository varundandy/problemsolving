package com.datastructures.patterns.twopointers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAString {

    public static void main(String[] args) {
        String[] inputs = {"Hello World", "We love Python", "The quick brown fox jumped over the lazy dog.", "Hey", "To be or not to be", "AAAAA", " Hello     World "};

        List<String> result = reverseString(inputs);
        System.out.println(result);
    }

    private static List<String> reverseString(String[] inputs) {
        return Arrays.asList(inputs).stream().map(reverseStringFunction).collect(Collectors.toList());
    }

    static TriFunction<String, Integer, Integer, String> reverse = (str, start, end) -> {
        char[] charArr = str.toCharArray();
        while (start < end) {
            char temp = charArr[end];
            charArr[end] = charArr[start];
            charArr[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(charArr);
    };
    static Function<String, String> reverseStringFunction = str -> {
       //sanitize the string.
        String sanitizedInput = cleanSpaces(str);
        StringBuilder sb = new StringBuilder(sanitizedInput);
        // reverse the whole string
        String reversedString = reverse.apply(sanitizedInput, 0, sanitizedInput.length() - 1);

        char[] charArr = reversedString.toCharArray();
        int start = 0;
        int end = 0;
        while (end <= charArr.length - 1) {
            if (Character.isSpaceChar(charArr[end])) {
                // take substring of array from start to end-1 and swap.
                charArr = reverse.apply(String.valueOf(charArr), start, end - 1).toCharArray();
                start = end + 1;
            }
            if (end == charArr.length - 1) {
                charArr = reverse.apply(String.valueOf(charArr), start, end).toCharArray();
                return String.valueOf(charArr);
            }
            end = end + 1;
        }
        return String.valueOf(charArr);
    };

    // trim leading, trailing and multiple spaces
    static String cleanSpaces(String str) {
        // Trim extra spaces at the beginning and end of the string
        // And replace multiple spaces with a single space
        str = str.replaceAll("\\s+", " ").trim();

        return str;
    }
}



@FunctionalInterface
interface TriFunction<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}
