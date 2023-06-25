package com.datastructures.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        stockPrice.put("Google", 421);
        stockPrice.put("Ford", 456);
        stockPrice.put("Novartis", 43);
        stockPrice.put("TCS", 23);

        System.out.println("Key with highest value:"+ getHighestValue(stockPrice));
        System.out.println("Avg  value:"+  getAvgOfValues(stockPrice));
        removeEntries(stockPrice, 50);
        System.out.println("New Values:"+ stockPrice.toString());



    }

    private static void removeEntries(Map<String, Integer> stockPrice, int limit) {

    Iterator<Entry<String, Integer>> it = stockPrice.entrySet().iterator();
    while(it.hasNext()){
        Entry<String, Integer> entry = it.next();
        if(entry.getValue() < limit)
        {
           it.remove();
        }
    }
    }

    private static Integer getAvgOfValues(Map<String, Integer> stockPrice) {
        int size = stockPrice.size();
        int avg = (stockPrice.values().stream().reduce(0, Integer::sum))/size;
        return avg;
    }

    private static String getHighestValue(Map<String, Integer> stockPrice) {

        int max = 0;
        String maxKey = null;
       for(Entry<String, Integer> entry: stockPrice.entrySet())
       {
           if( entry.getValue() > max){
               max = entry.getValue();
               maxKey = entry.getKey();
           }
       }
       return maxKey;

    }
}
