package com.datastructures.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangePositiveNegativeValues {

    public static void main(String args[]) {
        int[] input = {-10, 10, 7, -7, 8, -8, 5, -5};
        int[] result = rearrangeArray(input);
        Arrays.stream(input).forEach(System.out::println);
    }

    public static int[] rearrangeArray(int[] input) {

        int leftMostPositiveNumber = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                if (i != leftMostPositiveNumber) {
                    swap(input, i, leftMostPositiveNumber);
                }
                leftMostPositiveNumber++;
            }

        }


        return input;

    }

    public static void swap(int[] input, int source, int target) {
        int temp = input[target];
        input[target] = input[source];
        input[source] = temp;
    }
}
