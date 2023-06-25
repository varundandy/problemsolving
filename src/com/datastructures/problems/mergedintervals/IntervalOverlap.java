package com.datastructures.problems.mergedintervals;


import java.util.*;

public class IntervalOverlap {


    public static boolean isOverlapping(List<Interval> input) {

        Collections.sort(input, Comparator.comparingInt(a -> a.start));

        Iterator<Interval> iterator = input.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()) {

            Interval next = iterator.next();
            if (next.start <= end) {
                return true;
            } else {
                start = next.start;
                end = next.end;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        boolean result = IntervalOverlap.isOverlapping(input);
        System.out.println("Merged intervals: " + result);

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(8, 9));
        result = IntervalOverlap.isOverlapping(input);
        System.out.println("Merged intervals: " + result);


        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        result = IntervalOverlap.isOverlapping(input);
        System.out.println("Merged intervals: " + result);
    }

}
