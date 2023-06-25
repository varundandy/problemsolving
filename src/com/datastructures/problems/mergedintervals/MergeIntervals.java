package com.datastructures.problems.mergedintervals;


import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};


public class MergeIntervals {


    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        Iterator<Interval> iterator = intervals.iterator();
        Interval interval = iterator.next();
        int start = interval.start;
        int end = interval.end;

        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (next.start < end) // overlapping interval, adjust the end
            {
                end = Math.max(next.end, end);
            } else
            {
                mergedIntervals.add(new Interval(start, end));
                start = next.start;
                end = next.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
