package com.datastructures.patterns.patterns.twopointers;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
*
*Given an array, colors, which contains a combination of the following three elements:
0
 (representing red)
1
 (representing white)
2
 (representing blue)
Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white, and blue. To improve your problem-solving skills, do not utilize the built-in sort function.
*
* */
public class SortColor {

    public static void main(String args[]) {

        int[] input1 = {2, 0, 2, 1, 1, 0};
        int[] input2 = {1, 2, 0};
        int[] input3 = {2, 2, 1, 0, 0};

        Object[] multidimensionalArray = {
                input1,
                input2,
                input3
        };

        Object[] result = sortColors.apply(multidimensionalArray);
        Arrays.asList(result).stream().forEach(arr -> System.out.println(Arrays.toString((int[]) arr)));
    }


    public static void swap(int[] input, int sourceIndex, int targetIndex) {

        int temp = input[targetIndex];
        input[targetIndex] = input[sourceIndex];
        input[sourceIndex] = temp;

    }

    public static int[] sortColors(int[] colors) {

        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                swap(colors, current, start);
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else if (colors[current] == 2) {
                swap(colors, current, end);
                end--;
            }
        }

        return colors;
    }


    public static Function<Object[], Object[]> sortColors = inputs -> {
        return Arrays.asList(inputs).stream().map(input -> sortColors((int[]) input)).toArray();
    };


}
