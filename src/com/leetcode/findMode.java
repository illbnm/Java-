package com.leetcode;

public class findMode {
    /**
     * 1.超出时间限制
     *
     * @param
     */
//    public int majorityElement(int[] nums) {
//        int value = 0;
//        int S = 0;
//        for (int i = 0; i < nums.length; i++) {
//            value += nums[i];
//        }
//        S = value / nums.length;
//        int j = 0 ;
//        while (j<nums.length){
//            if (nums[j]>S)
//                return nums[j];
//
//        }
//        return 0 ;
//    }
    public int majorityElement(int[] nums) {
        int res = 0; // 当前判重的数字
        int num_i = 0;  //nums中的重复数字个数
        for (int num : nums) {
            if (num_i == 0) {
                res = num;
                ++num_i;
            } else if (num == res) {
                ++num_i;
            } else
                --num_i;
        }
            return res;
        }


    public static void main(String[] args) {

    }
}
