package com.saeed.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalMerger {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(interval -> interval.start));

        List<Interval> mergedIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while ((i+1) < intervals.size() && intervals.get(i).end >= intervals.get(i+1).start) {
                end = Math.max(end, intervals.get(++i).end);
            }
            mergedIntervals.add(new Interval(start, end));
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18),
                new Interval(4, 8)
        );

        List<Interval> result = mergeIntervals(input);
        System.out.println(result); // Expected: [(1,10), (15,18)]
    }
}
