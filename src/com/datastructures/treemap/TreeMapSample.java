package com.datastructures.treemap;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeMapSample {

    public static void main(String args[]){

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Varun", 10);
        map.put("Arun", 14);
        map.put("Tarun", 19);
        map.put("Carun", 7);
        map.put("Marun", 7);
        System.out.println(map);
        System.out.println(sortByValues(map));
        System.out.println(sortByValues2(map));

    }

    private static boolean sortByValues2(TreeMap<String, Integer> map) {
      /* return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));*/
        return false;
    }

    private static Map<String, Integer> sortByValues(TreeMap<String, Integer> map) {
        Comparator<String> valueComparator = (k1, k2) -> {
           int comp = map.get(k1).compareTo(map.get(k2));
           if(comp ==0)
               return 1;
           else
               return comp;
        };

        TreeMap<String, Integer> sortedValuesMap = new TreeMap<>(valueComparator.reversed());
        sortedValuesMap.putAll(map);
        return sortedValuesMap;
    }
}
