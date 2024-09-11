package com.datastructures.patterns.patterns.fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static void main(String args[]) {

        int[] inputArray = {1, 2, 3, 4, 5, 5, 6};
        int result = findDuplicate(inputArray);
        System.out.println(result);

    }

    public static int findDuplicate(int[] inputArray) {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < inputArray.length - 1; i++) {

            if (intSet.contains(inputArray[i])) {
                return inputArray[i];
            } else
                intSet.add(inputArray[i]);
        }
        return 0;
    }


}
