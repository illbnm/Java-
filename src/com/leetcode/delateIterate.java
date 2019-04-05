package com.leetcode;

import java.util.Arrays;

public class delateIterate {

//    public static int getLterate(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        int count = 0;
//        Arrays.sort(nums);
//       // System.out.println(Arrays.toString(nums));
//        while (left < right) {
//            if (nums[left + 1] == nums[left]) {
//                count++;
//            }
//            left++;
//        }
//        return count;
//    }

    public static int[] removeDuplicates(int[] nums) {
        int le = 0;
        int ri = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        while (le < ri) {
            if (nums[le + 1] == nums[le]) {
                count++;
            }
            le++;
        }


        int length = nums.length;

        Arrays.sort(nums);
        int[] brr = Arrays.copyOf(nums, nums.length - count);

        //System.out.println(Arrays.toString(brr));
        int left = 1;
        int i_brr = 0;
        while (left < length) {
            if (nums[left] == nums[left - 1]) {
                brr[i_brr] = nums[left];
            } else {
                i_brr++;
                brr[i_brr] = nums[left];
            }
            left++;
        }
        return brr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 1, 1, 2, 1, 2, 8, 5, 7};
        delateIterate D = new delateIterate();

        // System.out.println(getLterate(nums));
        int[] brr = removeDuplicates(nums);
        System.out.println(Arrays.toString(brr));
    }
}
