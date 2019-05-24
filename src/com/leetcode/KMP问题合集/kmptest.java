package src.com.leetcode.KMP问题合集;

import java.util.Arrays;

public class kmptest {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getnext(str2);

        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getnext(char[] str2) {
        int n = str2.length;
        int i = 0;
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0; //当前调的位置
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[n];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String brr = "abaaba";
        char[] arr = brr.toCharArray();
        int[] next = getnext(arr);
        System.out.println(Arrays.toString(next));
    }

}
