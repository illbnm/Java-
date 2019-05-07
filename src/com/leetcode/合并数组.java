package src.com.leetcode;

public class 合并数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int num = m-1+n-1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[m]) {
                nums1[num--] = nums1[m--];
            } else nums1[num--] = nums2[m--];
           while(n>=0) {
                nums1[num--] = nums2[n--];
            }
        }
    }
}
