package com.datastructures.patterns.mergeintervals;

import java.util.*;

public class MergeInterval {

    public static void main(String[] args) {

        List<Interval> l1 = Arrays.asList(new Interval(1, 5), new Interval(6, 7), new Interval(4, 6));
        List<Interval> l2 = Arrays.asList(new Interval(1, 5), new Interval(5, 6), new Interval(6, 8), new Interval(11, 15));
        List<Interval> l3 = Arrays.asList(new Interval(3, 7), new Interval(6, 8), new Interval(10, 12), new Interval(11, 15));
        List<Interval> l4 = Arrays.asList(new Interval(1, 5));
        List<Interval> l5 = Arrays.asList(new Interval(1, 9), new Interval(3, 8), new Interval(4, 4));
        List<Interval> l6 = Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(8, 8));
        List<Interval> l7 = Arrays.asList(new Interval(1, 5), new Interval(1, 3));
        List<Interval> l8 = Arrays.asList(new Interval(1, 5), new Interval(6, 9));
        List<Interval> l9 = Arrays.asList(new Interval(0, 0), new Interval(1, 18), new Interval(1, 3));
        List<List<Interval>> allIntervals = Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9);
        for (int i = 0; i < allIntervals.size(); i++) {
            System.out.println(i + 1 + ".\tIntervals to merge: " + allIntervals.get(i));
            List<Interval> result = mergeIntervals(allIntervals.get(i));
            System.out.println("\tMerged intervals: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    //Time Complexity - O(nlogn)
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        Iterator<Interval> itr = intervals.iterator();
        Interval interval = itr.next();
        int start = interval.start;
        int end = interval.end;
        while (itr.hasNext()) {
            Interval next = itr.next();
            if (next.start <= end) { //overlapping interval, adjust the end
                end = Math.max(next.end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = next.start;
                end = next.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }
}


class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}