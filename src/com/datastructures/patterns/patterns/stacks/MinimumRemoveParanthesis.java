package com.datastructures.patterns.patterns.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumRemoveParanthesis {

    public static void main(String args[]) {


        String[] inputs = {"ab)ca(so)(sc(s)(", "(((abc)(to)((q)()(", ")((ab)c))(ac(op)t(())(", ")(", ")()r(s(t(q(v)(w(x)y)z())((()("};
        List<String> result = removeParanthesis(inputs);
        result.stream().forEach(System.out::println);

    }

    public static List<String> removeParanthesis(String[] inputs) {

        return Arrays.stream(inputs).toList().stream().map(input -> minimumRemoveParanthesis.apply(input)).collect(Collectors.toList());

    }

    public static Function<String, String> minimumRemoveParanthesis = input -> {

        Stack<int[]> stack = new Stack<>();
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            char val = input.charAt(i);
            if (!stack.isEmpty() && stack.peek()[0] == '(' && val == ')') {
                stack.pop();
            } else if (val == '(' || val == ')') {
                stack.push(new int[]{val, i});
            }
        }
        while (!stack.isEmpty()) {
            inputArray[stack.pop()[1]] = ' ';
        }

        return String.valueOf(inputArray).replaceAll("\s+","");

    };
}
