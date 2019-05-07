package src.com.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 */
public class 移动零 {

    static public void moveZeroes(int[] nums) {
        int start = 0;
        int second = 0;
        while (second < nums.length && start < nums.length) {
            if (nums[start] == 0) {
                while (second < nums.length) {

                    if(nums[second]!=0){
                    int temp = nums[start];
                    nums[start] = nums[second];
                    nums[second] = temp;
                    second =start+1;
                    start++;
                    break;
                    }else{
                        second++;
                    }
                }
            } else
                start++;
        }


        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {1,0};
        moveZeroes(arr);
    }
}
