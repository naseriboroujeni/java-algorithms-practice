package com.saeed.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSumPairs {

    private final int[] nums1;
    private final int[] nums2;
    Map<Integer, Long> valueFreq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        valueFreq2 = Arrays.stream(nums2)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
    }

    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = oldValue + val;
        nums2[index] = newValue;
        valueFreq2.put(oldValue, valueFreq2.get(oldValue) - 1);
        valueFreq2.put(newValue, valueFreq2.getOrDefault(newValue, 0L) + 1);


    }

    public int count(int tot) {
        int count = 0;
        for (int j : nums1) {
            int remaining = tot - j;
            if (valueFreq2.containsKey(remaining)) {
                count += valueFreq2.get(remaining);
            }
        }
        return count;
    }
}
