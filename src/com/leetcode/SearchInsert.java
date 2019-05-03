package src.com.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
//    static public int binarySearch(int[] nums, int left, int right, int target) {
//        int mid = (left + right) / 2;
//        int flag = 0;
//        if(left >right){
//            return flag;
//        }
//        if (nums[mid] == target&&mid == 0 ) {
//            return mid;
//        }
//        if(mid == 0 ){
//            return  flag;
//        }
//        if (nums[mid] > target) {
//            binarySearch(nums, left, mid - 1, target);
//        }
//        if (nums[mid] < target) {
//            binarySearch(nums, mid + 1, right, target);
//        }
//        return flag+1;
//    }
//
//    static  public int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length ;
//        int num = binarySearch(nums, left, right,target);
//        return num;
//    }
static  public int searchInsert(int[] nums, int target) {
        int left = 0 ; int flag =0 ;
        int right = nums.length-1;
        int mid = 0 ;
        while(left <= right){

            mid = (left + right)/2;
            if(nums[mid] == target){
                return  mid;
            }
            if(nums[mid] <target){
                 left = mid+1 ;
            }
            if(nums[mid] > target){
                right = mid -1 ;
            }
        }
        return left;
}
    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int num = searchInsert(nums,0);
        System.out.println(num);
    }
}
