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
            while ((i+1) < intervals.size() && end >= intervals.get(i+1).start) {
                end = Math.max(end, intervals.get(++i).end);
            }
            mergedIntervals.add(new Interval(start, end));
        }
        return mergedIntervals;
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        int[][] mergedIntervals = new int[intervals.length][2];

        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while ((i+1) < intervals.length && end >= intervals[i+1][0]) {
                end = Math.max(end, intervals[++i][1]);
            }
            mergedIntervals[j][0] = start;
            mergedIntervals[j][1] = end;
            j++;
        }
        return Arrays.copyOfRange(mergedIntervals, 0, j);
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

        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] result2 = mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(result2));
    }
}
