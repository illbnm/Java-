package com.leetcode;

import java.util.Arrays;

public class removeValue {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            while (nums[left] == val && left <= right) {


            }

        }

        return nums.length;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 4, 5, 6, 7, 89, 2, 2, 3};
//        int value = 2;
//        int brr = removeElement(arr, value);
//        System.out.println(brr);
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
//        System.out.println("a的地址:"+a.hashCode()+"b的地址:"+b.hashCode());
    }
}
