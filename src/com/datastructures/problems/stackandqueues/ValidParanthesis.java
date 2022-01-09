package com.datastructures.problems.stackandqueues;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * */
public class ValidParanthesis{

    public static void main(String args[]) {

        List<String> inputs = new ArrayList<>();
        inputs.add("{[()]}");
        inputs.add("{[]()}");
        inputs.add("{[(])}");
        inputs.add("");
        inputs.add("(]");
        inputs.add("]");
        inputs.add("(");
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('[', ']');
        pair.put('{', '}');

        List<Boolean> result = isValidParathesis(inputs, stack, pair);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<Boolean> isValidParathesis(List<String> inputs, Stack<Character> stack, Map<Character, Character> pair) {
        return inputs.stream().map(l -> isValid(stack, pair).apply(l)).collect(Collectors.toList());

    }

    private static Function<String, Boolean> isValid(Stack<Character> stack, Map<Character, Character> pair) {
        // {[()]};
        return (x) -> {
            if(x.length()== 0)
            {
                return true;
            }
            for (int i = 0; i < x.length(); i++) {
                char character = x.charAt(i);
                if (pair.containsKey(character)) {
                    stack.push(character);
                } else {
                    char leftBracket;
                    if(stack.empty())
                    {
                        return false;
                    }
                    leftBracket = stack.pop();
                    char rightBracket = pair.get(leftBracket);
                    if (!(rightBracket == character)) {
                        return false;
                    }
                }
            }
            return stack.size() == 0;
        };
    }
}
