package com.leetcode;

import java.util.Arrays;

public class findArrLocation {
    public int[] searchRange(int[] nums, int target) {
        int a[] = new int [2];
        a[0] = -1 ;
        a[1] = -1 ;
        int begin =0;int end =nums.length-1;
        while(begin<=end){

            if(nums[begin++] == target)
                a[0] = begin ;
            if(nums[end--]== target){
                a[1] = end;
            }

        }

        return a;
    }
    public static void main(String[] args) {
        int arr[] = { 5,7,7,8,8,10};
        int t = 8 ;
        findArrLocation A =new findArrLocation();
        System.out.println(Arrays.toString(A.searchRange(arr,t)));
    }
}
