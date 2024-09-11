package com.datastructures.patterns.patterns.twopointers;

public class ValidPallindromeII {

    public static void main(String args[]) {

        String input = "madame";
        Boolean result = isValidPallindrome(input);
        System.out.println(result);
    }

    private static Boolean isValidPallindrome(String input) {

        int skip = 0;
        int i = 0;
        int j = input.length() - 1;
        while (i <= j) {
            if (input.charAt(i) != input.charAt(j)) {
                // check if either case pallindrome.
                return isPallindrome(input, i + 1, j) || isPallindrome(input, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public static Boolean isPallindrome(String input, int i, int j) {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
