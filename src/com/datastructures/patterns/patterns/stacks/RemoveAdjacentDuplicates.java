package com.datastructures.patterns.patterns.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveAdjacentDuplicates {

    public static void main(String args[]) {
        String input = "aaabcd";
        String[] inputs = {"ggaabcdeb", "g", "abbddaccaaabcd", "aabbccdd", "aannkwwwkkkwna"};
        List<String> result = removeAdjacentDuplicates(inputs);
        result.stream().forEach(System.out::println);
    }

    private static List<String> removeAdjacentDuplicates(String[] inputs) {
        // Define the function for removing adjacent duplicates
        return Arrays.stream(inputs).toList().stream().map(input -> removeAdjacentDuplicates.apply(input)).collect(Collectors.toList());
    }

    public static Function<String, String> removeAdjacentDuplicates = input -> {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (!s.isEmpty() && input.charAt(i) == s.peek()) {
                s.pop();
            } else {
                s.push(input.charAt(i));
            }
        }
        String reversedString = "";
        while (!s.isEmpty()) {
            reversedString = reversedString + String.valueOf(s.pop());
        }
        return reverseString(reversedString);
    };

    private static String reverseString(String reversedString) {
        String result = "";
        for (int i = reversedString.length() - 1; i >= 0; i--) {
            result = result + reversedString.charAt(i);
        }
        return result;
    }
}
