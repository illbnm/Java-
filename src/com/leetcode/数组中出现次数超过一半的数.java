package src.com.leetcode;

public class 数组中出现次数超过一半的数 {

    public int MoreThanHalfNum_Solution(int[] array) {
        int nu = 0;
        int nu2 = 0;
        int cur = 0;
        for (int num : array) {
            if (nu == 0) {
                cur = num;
                ++nu;
            } else if (cur == num) {
                ++nu;
            } else {
                --nu;
            }
        }
        for (int s : array) {
            if (s == cur) {
                nu2++;
            }
        }
        if (nu2 >= array.length / 2) {
            return cur;
        } else {
            return 0;
        }
    }

}
