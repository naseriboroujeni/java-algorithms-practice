package com.saeed.stream;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;

        int nums1Index = m - 1;
        int nums2Index = n - 1;
        for (int i = total - 1; i >= 0; i--) {
            int numToAdd;
            if (nums1Index < 0) {
                numToAdd = nums2[nums2Index--];
            } else if (nums2Index < 0) {
                numToAdd = nums1[nums1Index--];
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                numToAdd = nums2[nums2Index--];
            } else {
                numToAdd = nums1[nums1Index--];
            }
            nums1[i] = numToAdd;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        merge(nums1, 3, nums2, 3);
        // Expected nums1 after merge: [1, 2, 2, 3, 5, 6]
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
