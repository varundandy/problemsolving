package com.datastructures.problems;

//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined

import java.util.HashMap;
import java.util.Map;

//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2
public class FirstRecurringCharacter {
    public static void main(String args[]) {

        String arr[] = {"5", "2", "1", "2", "3", "4", "1", "2", "4"};

        String result1 = extracted(arr);
        System.out.print(result1);
        String result2 = extractedUsingMap(arr);
        System.out.println(result2);

    }

    private static String extracted(String[] arr) {
        outerloop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    return arr[i];
                }
            }
        }
        return null;
    }

    private static String extractedUsingMap(String[] arr) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return arr[i];
            } else {
                map.put(arr[i], String.valueOf(i));
            }
        }
        return null;
    }
}



