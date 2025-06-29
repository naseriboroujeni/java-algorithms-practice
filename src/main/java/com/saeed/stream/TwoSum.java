package com.saeed.stream;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] result1 = twoSum(new int[]{2, 7, 11, 15}, 9);  // Expected: [0,1]
        int[] result2 = twoSum(new int[]{3, 2, 4}, 6);      // Expected: [1,2]
        int[] result3 = twoSum(new int[]{3, 3}, 7);        // Expected: [0,1]

        System.out.println(java.util.Arrays.toString(result1));
        System.out.println(java.util.Arrays.toString(result2));
        System.out.println(java.util.Arrays.toString(result3));
    }
}
