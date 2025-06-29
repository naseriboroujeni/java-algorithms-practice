package com.saeed.stream;

public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {
        int area = 0;
        int start = 0;
        int end = heights.length - 1;
        while (start < end) {
            area = Math.max(area, (end - start) * Math.min(heights[start], heights[end]));
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));  // Expected: 49
        System.out.println(maxArea(new int[]{1,1}));               // Expected: 1
    }
}
