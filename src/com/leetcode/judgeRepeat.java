package com.leetcode;

public class judgeRepeat {
    public boolean containsDuplicate(int[] nums) {
        int[] hash = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            hash[nums[i]] = 1;
            if (hash[nums[i]] != 0)
                return true;
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
            
    }
}
