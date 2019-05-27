package src.com.leetcode;

import java.util.Arrays;

public class 只出现一次字符的位置 {
    public int FirstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        int[] asc = new int[128];
        int i = 0;
        while (i < str.length()) {
            char m = arr[i];
            asc[m] += 1 ;
        }
        i = 0;
        while (i < 128) {
            if (asc[i] == 1) {

            }
        }

        return 0;
    }


    public static void main(String[] args) {

    }
}
