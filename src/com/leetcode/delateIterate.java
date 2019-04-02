package com.leetcode;

import java.util.Arrays;

public class delateIterate {

    public   static int getLterate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while (left < right) {
            if (nums[left + 1] == nums[left]) {
                count++;
            }
            left++;
        }
        return count;
    }

    public static int [] removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = getLterate( nums);

       int []brr= Arrays.copyOf(nums,nums.length-count);

       //System.out.println(Arrays.toString(brr));
        int left = 0 ;
        int i_brr=0;
        while(left<length-1){
            if(nums[left+1]==nums[left]){
                brr[i_brr] = nums[left];
            }
            if(nums[left+1] != nums[left]){
                i_brr++;
                nums[i_brr] = nums[left+1];

            }
            left++;
        }
        return brr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 1, 1, 2, 1, 2, 8, 5, 7};
        delateIterate D = new delateIterate();
        getLterate(nums);
       // System.out.println(getLterate(nums));
       int []brr =  removeDuplicates(nums);
        System.out.println(Arrays.toString(brr));
    }
}
