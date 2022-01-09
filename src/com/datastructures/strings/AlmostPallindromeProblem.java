package com.datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlmostPallindromeProblem {

    public static void main(String args[]) {
        List<String> inputs = getInputList("A man, a plan, a canal: Panama", "aabbaa", "", "abc", "a", "racebacar","hivxjgijdatxwxfbzumrbgpjspwwlvphohoyrnlkrpnjtvxyyeykeaxxjsvgzpgffgdzhpqpczazqepsqwktvckxlncqpefkokltnjfusxhnoseexqgaejygupogfblusljvdrkrijeaydlbbxeupiegzxvxuoasgnvhzqhjtyyycuzmxeqxeuaegetyvppavhrbjoapocqggpauzdbjueuscaivmltwftoebyhmuotlvmesuufuvrkchpyabtangyytomdrksnwqpaotpzkxgfkglbmtotazzpyonrczgrmnobvphxoexvlueuheacjpwsuzbextqylffjusclzxdxrqtcueloohlljvdqwbcbqkgvmdaelslwruhxvorpgvyuexgyyhxehipediftuwmedgsbepxocpqxzeqoxuaefvxpkopucexrnzzkigygsorgygtqasfqhqznugktwpzojbjfxnnqnnwcshbggxbcoczdlvmogkojmpjdmsjcqdqdzqypgfrkyztwxfmhlukezktsvyymypfgfvjjwcnukjtcnvqrdcmpfhcpuorcmbuekkhaadurnpepjlmcxhwrmyxxvolkkvknxdacvmhbhxsjrfqplektzdzoezunficvcfptmgeldrinnetsllcrspethdslnpkwannupjaryddtlidxkcqbhguhxxhacztbfgynilusgjlcdzhmksqqveokoaailhtfnbahwjtauocakwxhbkzcmceihehcckjtojijundwdzrzhcmnhhywvdysswqzkfnbmyitlybljgnvytkdbpnaloafargfivdwazeypnhjttaichmjmqftnsvrojqcncdaxkgwmpxswuzkbsablncfkklzuvxexvbmxwprgzaxznvkxomrpaqjqepjuawjcswjrhljkiuavqaaamencoxvebjjglufspbttvqdmpbclzjeozuwfqrphkdvepkyjmdaunln");
        List<Boolean> result = isAlmostAPallindrome(inputs, isAPallindrome());
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<Boolean> isAlmostAPallindrome(List<String> inputs, Function<String, Boolean> aPallindrome) {

        return inputs.stream().map(l -> removeSpecialChar().apply(l)).map(l -> isAlmostAPallindrome().apply(l)).collect(Collectors.toList());

    }

    private static Function<String, String> removeSpecialChar()
    {
        return (x) -> x.replaceAll("[^A-Za-z0-9]","").toLowerCase(Locale.ROOT);
    }

    private static Function<String, Boolean> isAlmostAPallindrome() {
        return (x) -> {
            int i = 0;
            int j = x.length() - 1;
            while (i < j) {
                if (x.charAt(i) != x.charAt(j)) {
                    if (!(isSubPallindrome(x,i,j-1) || isSubPallindrome(x, i+1, j))) {
                        return false;
                    }
                }
                i++;
                j--;
            }
            return true;
        };

    }

    private static List<String> getInputList(String... inputList) {
        List<String> inputs = new ArrayList<>();
        for (String i : inputList) {
            inputs.add(i);
        }
        return inputs;
    }

    private static Boolean isSubPallindrome(String input, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            if (input.charAt(leftPointer) != input.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }


    private static Function<String, Boolean> isAPallindrome() {
        return (x) -> {
            return isStringAPallindrome(x);
        };

    }

    private static Boolean isStringAPallindrome(String x) {
        int i = 0;
        int j = x.length() - 1;
        while (i <= j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
