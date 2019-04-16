package com.leetcode;

import java.util.Arrays;

public class mergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int arr[] = new int[n + m + n];
//        int arr_t = 0;
//        int i = 0, j = 0;
//        while (i <= n || j <= m) {
//            if (i > m && j <= n) {
//                arr[arr_t++] = nums2[j++];
//                if (i >= m && j >= n) {
//                    break;
//                }
//            } else if (j > n && i <= m) {
//                arr[arr_t++] += nums1[i++];
//                if (i >= m && j >= n) {
//                    break;
//                }
//            } else if (nums1[i] >= nums2[j]) {
//                arr[arr_t++] = nums2[j++];
//            } else {
//                arr[arr_t++] = nums1[i++];
//            }
//
//        }
//
//        nums1 = arr.clone();
//
//        System.out.println(Arrays.toString(arr));
        int last = n + m - 1;
        int i1 = n - 1;
        int i2 = m - 1;
        if (last >= 0) {
            while (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[last] = nums1[i1--];
                } else {
                    nums1[last] = nums2[i2--];
                }
                last--;
            }
            if (i2 > 0) {
                while (i2 >= 0) {
                    nums1[last--] = nums2[i2--];
                }
            }
        }
        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeArray A = new mergeArray();
        A.merge(nums1, 3, nums2, 3);
    }
}
