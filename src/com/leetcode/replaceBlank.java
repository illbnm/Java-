package com.leetcode;

import java.util.Arrays;

public class replaceBlank {

    public static int getCount(char[] arr, char src) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == src) {
                count++;
            }
        }
        return count;
    }

    public static char[] replace(char[] arr, char src, int num, char aim) {
        if (arr == null) {
            return null;
        }
        int begin = 0;
        int end = arr.length - 1;
        int srcCount = getCount(arr, src);                      // 获取需要替换目标的个数
        char[] brr = new char[arr.length + srcCount * (num - 1)];
        int i = 0;
        int j = brr.length - 1;
        while (begin <= end) {                                     //begin end 为原数组的两头下标   i  j 为新数组的两头下标
            if (arr[begin] != src && begin <= end) {
                brr[i] = arr[begin];
                begin++;                    //原数组下标加一 新数组下标加一
                i++;
            } else {
                begin++;                            //替换时,原数组只加一次
                for (int k = 0; k < num; k++) {      //新数组在循环中加
                    brr[i] = aim;
                    i++;
                }
            }
            if (arr[end] != src && end > begin) {
                if (arr[end] != src) {
                    brr[j] = arr[end];
                    end--;
                    j--;
                } else {
                    end--;
                    for (int k = num; k > 0; k--) {
                        brr[j] = aim;
                        j--;
                    }
                }
            }
        }
        return brr;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//do something
        String str = "i am a student!";
        char[] arr = str.toCharArray();
        arr = replace(arr, ' ', 2, '#');
        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
