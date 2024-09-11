package com.datastructures.patterns.patterns.fastslowpointers;

public class HappyNumber {

    public static void main(String args[]) {
        int input = 23;
        boolean result = isHappyNumber(input);
        System.out.println(result);
    }

    public static boolean isHappyNumber(int input) {
        int slow = input;
        int fast = sumOfSquaredDigits(input);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        System.out.println("is it a Happy Number?: " + (fast == 1));
        return fast == 1;
    }

    public static Integer sumOfSquaredDigits(int number) {
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            totalSum = totalSum + Double.valueOf(Math.pow(digit, 2)).intValue();
            number = number / 10;
        }
        return totalSum;
    }
}
