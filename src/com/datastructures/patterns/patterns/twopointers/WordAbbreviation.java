package com.datastructures.patterns.patterns.twopointers;

public class WordAbbreviation {

    public static void main(String args[]) {

        String word = "z";
        String abbreviation = "2";

        Boolean result = checkAbbreviation(word, abbreviation);
        System.out.println(result);
    }

    private static Boolean checkAbbreviation(String word, String abbr) {
        int wordCounter = 0;
        int abbrCounter = 0;

        while (abbrCounter < abbr.length()) {
            char currrentChar = abbr.charAt(abbrCounter);

            if (isDigit(currrentChar)) {
                if (currrentChar == '0') { // Handle leading zero case
                    return false;
                }
                int jumpCounter = 0;
                while (abbrCounter < abbr.length() && isDigit(abbr.charAt(abbrCounter))) {
                    jumpCounter = jumpCounter * 10 + (abbr.charAt(abbrCounter) - '0');
                    abbrCounter++;
                }
                wordCounter += jumpCounter;
            } else {
                if (wordCounter >= word.length() || currrentChar != word.charAt(wordCounter)) {
                    return false;
                }
                wordCounter++;
                abbrCounter++;
            }
        }
        return wordCounter == word.length();
    }

    public static Boolean isDigit(char character) {
        if (character >= '0' && character <= '9') {
            return true;
        }
        return false;
    }


}
