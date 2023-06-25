package com.datastructures.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParanthesisChecker {

    public static void main(String args[]) {
        String input = "{([]())}";
        boolean result = checkParanthesis(input);
        System.out.println(result);
    }

    private static boolean checkParanthesis(String input) {

        Stack stack = new Stack<Character>();
        Map bracketMap = new HashMap<Character, Character>();
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        bracketMap.put(')', '(');
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                if (bracketMap.get(Character.valueOf(chars[i])) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
