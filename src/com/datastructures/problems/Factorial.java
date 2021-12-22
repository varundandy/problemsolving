package com.datastructures.problems;

public class Factorial {

    public static void main(String args[]) {
        int input = 5;
        int result = factorialWithRecursion(input);
        System.out.println(result);
        int result2 = factorialWithoutRecursion(input);
        System.out.println(result2);

    }

    private static int factorialWithoutRecursion(int input) {
        int result = 1;
        for (int i = input; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    private static int factorialWithRecursion(int input) {
        int result = 1;
        if (input == 1) {
            return result;
        }
        result = input * factorialWithRecursion(input -1);
        return result;
    }

}
