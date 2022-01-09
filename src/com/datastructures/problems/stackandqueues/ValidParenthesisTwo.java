package com.datastructures.problems.stackandqueues;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 */
public class ValidParenthesisTwo {


    public static void main(String args[]) {


        List<String> inputs = new ArrayList<>();
        inputs.add("lee(t(c)o)de)");
        inputs.add("a)b(c)d");
        inputs.add("");
        inputs.add("((");
        inputs.add("()");
        inputs.add("())");
        List<String> result = convertIntoValidParanthesis(inputs);

        System.out.println(Arrays.toString(result.toArray()));
    }

    public static List<String> convertIntoValidParanthesis(List<String> inputs) {

        return inputs.stream().map(l -> convert().apply(l)).collect(Collectors.toList());

    }

    private static Function<String, String> convert() {
        return (x) -> {
            Stack<Integer> stack = new Stack();
            char[] input = x.toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    stack.push(i);
                }
                if (input[i] == ')') {
                    if (!stack.empty()) {
                        stack.pop();
                    } else  {
                        input[i] = ' ';
                    }
                }
            }
            while(!stack.isEmpty())
            {
                int toRemove = stack.pop();
                input[toRemove] = ' ';
            }
            return new StringBuilder().append(input).toString().replaceAll(" ","");
        };
    }
}

