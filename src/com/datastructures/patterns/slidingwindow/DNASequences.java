package com.datastructures.patterns.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DNASequences {

    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            Set<String> output = findRepeatedSequences(inputsString.get(i), inputsK.get(i));
            System.out.println(output);
            System.out.println("----------------------------------------------------");
        }
    }

    public static Set<String> findRepeatedSequences(String s, int k) {
        int start = 0;
        int end = k;
        int length = s.length();
        Set<String> set = new HashSet<>();
        Set<String> output = new HashSet<>();
        while(end <= length){
            String value =  s.substring(start, end);
            if(set.contains(value)){
               output.add(value);
            } else{
                set.add(value);
            }
            start++;
            end++;
        }

        return output;
    }

}
