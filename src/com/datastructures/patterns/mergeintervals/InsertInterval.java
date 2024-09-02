package com.datastructures.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a sorted list of nonoverlapping intervals and a new interval, your task
 * is to insert the new interval into the correct position while ensuring that the resulting
 * list of intervals remains sorted and nonoverlapping. Each interval is a pair of nonnegative numbers,
 * the first being the start time and the second being the end time of the interval.
 * **/
public class InsertInterval {

    public static void main(String[] args) {
        Interval[] newIntervals = {
                new Interval(5, 7),
                new Interval(8, 9),
                new Interval(10, 12),
                new Interval(1, 3),
                new Interval(1, 10)
        };

        List<List<Interval>> existingIntervals = new ArrayList<>();
        existingIntervals.add(Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 8)));
        existingIntervals.add(Arrays.asList(new Interval(1, 3), new Interval(5, 7), new Interval(10, 12)));
        existingIntervals.add(Arrays.asList(new Interval(8, 10), new Interval(12, 15)));
        existingIntervals.add(Arrays.asList(new Interval(5, 7), new Interval(8, 9)));
        existingIntervals.add(Arrays.asList(new Interval(3, 5)));

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.println("Existing intervals: " + existingIntervals.get(i));
            System.out.println("New interval: " + newIntervals[i].toString());
            insertInterval(new ArrayList<>(existingIntervals.get(i)), newIntervals[i]);
            System.out.println("New intervals: " + existingIntervals.get(i));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        List<Interval> output = new ArrayList<>();
        Iterator<Interval> itr = existingIntervals.iterator();
        int counter = 0;
        while (itr.hasNext()) {
            Interval next = itr.next();
           if(newInterval.end <= next.end){
               next.start = Math.min(newInterval.start, next.start);
           }

        }
        return existingIntervals;
    }
}
