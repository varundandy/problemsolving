package com.datastructures.problems.fastslowpointer;

public class HappyNumber {

    public static void main(String[] args) {


    }


    public static boolean isHappyNumber(int num) {

        return false;
    }

    public static int findSquaredSum(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum = sum + digit * digit;
            number = number / 10;
        }

        return sum;
    }


}
