package com.saeed.stream;

public class BinarySearch {

    public static int search(int[] sortedNums, int target) {
        int start = 0;
        int end = sortedNums.length - 1;
        while (start <= end) {
            int tempIndex = (start + end) / 2;
            if (sortedNums[tempIndex] == target) {
                return tempIndex;
            } else if (sortedNums[tempIndex] > target) {
                end = tempIndex - 1;
            } else {
                start = tempIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));  // Expected: 4
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));  // Expected: -1
    }
}
