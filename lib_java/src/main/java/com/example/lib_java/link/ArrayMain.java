package com.example.lib_java.link;

import java.util.Arrays;

/**
 * 合并两有序列表
 */
class ArrayMain {

    public static void main(String[] args) {
        int[] nums2 = {4, 14, 24, 34};
        int[] nums1 = {5, 9, 15, 36, 50, 0, 0, 0, 0};
        int[] nums = new int[20];
//        System.arraycopy(nums2, 1, nums, 4, 5);
//        System.out.println(Arrays.toString(nums));

        ArrayMain arrayMain = new ArrayMain();
        arrayMain.merge(nums1, 5, nums2, nums2.length);

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("m = " + m + ", n = " + n);
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
            System.out.println("p = " + p + ", p1 = " + p1 + ", p2 = " + p2);
            System.out.println(Arrays.toString(nums1));
        }
        System.out.println("p = " + p + ", p1 = " + p1 + ", p2 = " + p2);
        // if there are still elements to add
        if (p1 < m) {
            System.out.println("m - p1 = " + (m - p1));
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m - p1);
        }
        System.out.println(Arrays.toString(nums1));
        if (p2 < n) {
            System.out.println("n - p2 = " + (n - p2));
            System.arraycopy(nums2, p2, nums1, p1 + p2, n - p2);
        }

        System.out.println(Arrays.toString(nums1));
    }

}
