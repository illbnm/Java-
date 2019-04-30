package src.com.leetcode;

import java.util.Arrays;

/**
 * 找出那个只重复一次的数
 */
public class repeatOnce {
    public int singleNumber(int[] nums) {
            int result= 0 ;

        for(int i = 0;i<nums.length;i++){
            result ^= nums[i] ;
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums = new int[]{4,1,2,1,2};
        repeatOnce test = new repeatOnce();
        test.singleNumber(nums);
    }
}
