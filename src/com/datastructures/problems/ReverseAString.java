package com.datastructures.problems;

public class ReverseAString {


    public static void main(String args[]) {
        String val = "Hi My Name is Varun";
        String rev = reverseOneLoops(val);
        System.out.print(rev);

    }

    private static String reverseOneLoops(String val) {
        char revarr[] = new char[val.length()];
        int j = 0;
        while (j < val.length()) {
            for (int i = val.length()-1; i >= 0; i--) {
                revarr[j] = val.charAt(i);
                j++;
            }
        }
    return String.valueOf(revarr);
    }
}
