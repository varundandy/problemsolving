package com.datastructures.patterns.patterns.stacks;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ValidParanthesis {

    public static void main(String args[]) {

        String[] input = {"{}[]{}[{}])", "(){[{()}]}", "(((((", "{{()}", "{()}}"};
        List<Boolean> result = evaluateValidParanthesis(input);
        result.stream().forEach(System.out::println);

    }

    public static List<Boolean> evaluateValidParanthesis(String[] inputs) {
        return Arrays.stream(inputs).toList().stream().map(input -> isValidParathesis.test(input)).collect(Collectors.toList());
    }

    public static Predicate<String> isValidParathesis = input -> {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMapping = new HashMap<>();
        bracketsMapping.put('}', '{');
        bracketsMapping.put(']', '[');
        bracketsMapping.put(')', '(');
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            } else if (!stack.empty() && stack.peek().equals(bracketsMapping.get(currentChar))) {
                stack.pop();
            } else if (stack.empty()) {
                return false;
            }
        }
        return stack.isEmpty();
    };
}
