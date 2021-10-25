package com.datastructures.problems;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MergeSortedArrays {
    public static void main(String args[]) {
        int[] arr1 = {0, 3, 5, 9, 16, 25, 29, 31};
        int[] arr2 = {3, 4, 6, 30};
        // Object result[] = mergeSortedArraysUsingMap(arr1, arr2);
        int result[] = mergeSortedArrays(arr1, arr2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    //Option 1: just add all in one array and then use any sort algorithm
    //Option 2: Use a map--will loose duplicate values

    public static Object[] mergeSortedArraysUsingMap(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], String.valueOf(i));
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], String.valueOf(i));
        }
        Set<Integer> mergedSet = map.keySet();
        return mergedSet.toArray();
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        //  int[] arr1 = {0, 3, 4, 31};
        //int[] arr2 = {3, 4, 6, 30};
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
                k++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }
        return mergedArray;
    }

}
