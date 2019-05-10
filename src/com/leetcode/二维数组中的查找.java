package src.com.leetcode;

public class 二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        int cow = array.length - 1;
        int clo = 0;
        while (cow < array.length && clo < array[0].length) {
            if (array[cow][clo] == target) {
                return true;
            }
            if (array[cow][clo] > target) {
                cow--;
            } else
                clo++;

        }
        return false;
    }
}
