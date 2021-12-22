package com.datastructures.problems;

/**
 *
 *
 *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
 *  the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3
 *
 *  For example: fibonacciRecursive(6) should return 8
 */
public class Fibonacci {

    public static void main(String args[]) {
        int input = 6;
        int result = fibonacciWithRecursion(input);
        System.out.println(result);
        //int result2 = fibonacciWithoutRecursion(input);
        //  System.out.println(result2);

    }

    public static int fibonacciWithRecursion(int n) {
        int result = 1;
        if (n < 2) {
            return n;
        }
        result = fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
        return result;
    }

}
