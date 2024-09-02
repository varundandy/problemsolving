package com.datastructures.patterns.patterns.twopointers;

public class WordAbbreviation {

    public static void main(String args[]) {

        String word = "abcdefghijklmnopqrst";
        String abbreviation = "a18t";

        Boolean result = checkAbbreviation(word, abbreviation);
        System.out.println(result);
    }

    private static Boolean checkAbbreviation(String word, String abbr) {

        int wordCounter = 0;
        int abbrCounter = 0;

        while (abbrCounter < abbr.length() - 1) {
            char currrentChar = abbr.charAt(abbrCounter);
            char nextChar = abbr.charAt(abbrCounter + 1);
            if (isDigit(currrentChar)) {
                if (abbr.charAt(abbrCounter) == '0') {
                    return false;
                }
                int jumpCounter = Integer.parseInt(String.valueOf(currrentChar));
                if (isDigit(nextChar)) {
                    jumpCounter = Integer.parseInt(String.valueOf(currrentChar) + String.valueOf(nextChar));
                    abbrCounter++;
                }
                wordCounter = wordCounter + jumpCounter;
                abbrCounter++;
            } else if (currrentChar == word.charAt(wordCounter)) {
                wordCounter++;
                abbrCounter++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static Boolean isDigit(char character) {
        if (character >= '0' && character <= '9') {
            return true;
        }
        return false;
    }


}
