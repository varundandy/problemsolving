package com.datastructures.arrays;

import java.util.Arrays;

public class ProductOfElements {

    public static void main(String args[])
    {
        int[] array = new int[]{1,2,3,4,5,6,7};
        int[] result = productOfElements(array);
        Arrays.stream( result ).forEach( p ->  System.out.println(p));
    }

    private static int[] productOfElements(int[] array) {
        int[] result = new int[array.length];
        int k=0;

        int beforeValuesMultiplied = 1;
        for(int i = 0; i < array.length ; i++)
        {
            int multipliedValue = 1;
            for(int j = i + 1; j < array.length; j++)
            {
                multipliedValue = multipliedValue * array[j];
            }
            result[k] = multipliedValue * beforeValuesMultiplied;
            k++;
            beforeValuesMultiplied = beforeValuesMultiplied * array[i];
        }
        return result;
    }
}
