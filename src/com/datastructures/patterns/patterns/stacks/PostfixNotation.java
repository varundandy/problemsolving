package com.datastructures.patterns.patterns.stacks;

import java.util.Stack;

public class PostfixNotation {

    public static void main(String args[]) {

        String postFixExpression = "23*5+";
        int result = evaluatePostFixExpression(postFixExpression);
        System.out.println(result);

    }

    public static int evaluatePostFixExpression(String expression) {
        char[] expressionArray = expression.toCharArray();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < expressionArray.length; i++) {
            if (isNumber(expressionArray[i])) {
                s.push(Integer.parseInt(String.valueOf(expressionArray[i])));
            } else {
                int operand2 = s.pop();
                int operand1 = s.pop();

                switch (expressionArray[i]) {
                    case '+':
                        s.push(operand1 + operand2);
                        break;
                    case '-':
                        s.push(operand1 - operand2);
                        break;
                    case '*':
                        s.push(operand1 * operand2);
                        break;
                    case '/':
                        s.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

            }
        }
        return s.pop();
    }

    private static boolean isNumber(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
