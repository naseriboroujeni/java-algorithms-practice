package com.saeed.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int first = i + 1;
            int last = nums.length - 1;
            int tempGoal = -nums[i];
            while (first < last) {
                int tempSum = nums[first] + nums[last];
                if (tempSum > tempGoal) {
                    do {
                        last--;
                    } while (last > first && nums[last] == nums[last + 1]);
                } else if (tempSum < tempGoal) {
                    do {
                        first++;
                    } while (last > first && nums[first] == nums[first - 1]);
                } else {
                    result.add(List.of(nums[i], nums[first], nums[last]));
                    do {
                        last--;
                    } while (last > first && nums[last] == nums[last + 1]);
                    do {
                        first++;
                    } while (last > first && nums[first] == nums[first - 1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {-1, 0, 1, 2, -1, -4};
        int[] input2 = {0, 1, 1};
        int[] input3 = {-2, 0, 1, 1, 2};

        System.out.println(threeSum(input1));
        System.out.println(threeSum(input2));
        System.out.println(threeSum(input3));
    }
}
