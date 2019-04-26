package com.leetcode;

import java.util.Scanner;

public class StringToInt {
    public int toInt(String brr) {
        char[] arr = new char[brr.length()];
        arr = brr.toCharArray();
        double result = 0;
        int flag = 0;   //表示正号
        if (arr == null || arr.length < 1) {
            return (int) result;
        }
        int i = 0;
        while (i <= (arr.length - 1) && arr[i] == '-' || arr[i] == '+') {
            if (arr[i] == '-')
                flag *= -1;

            if (arr[i] == '+')
                flag *=1;

            i++;
        }
        int j = 0;

        while (i <= (arr.length - 1)) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                result = result * 10 + Integer.parseInt(String.valueOf(arr[i]));
                i++;
            } else {
                i++;
            }
        }

        if (flag == 1) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.next();
        StringToInt A = new StringToInt();
        A.toInt(arr);
        System.out.println(A.toInt(arr));
    }
}
