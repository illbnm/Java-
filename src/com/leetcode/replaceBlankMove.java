package com.leetcode;

import java.util.Arrays;

public class replaceBlankMove {
    public static int getCount(char[] arr, int src) {
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
        int arrCount = arr.length - 1;             //保存arr最开始的末尾值
        int srcCount = getCount(arr, src);
        arr = Arrays.copyOf(arr, arr.length + srcCount * (num - 1));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == src) {

                for (int j = arrCount; j > i; j--) {                        //先移位将i后面的元素移动num-1位
                    arr[j + num - 1] = arr[j];
                }
                for (int k = i; k <= i + num - 1; k++) {
                    arr[k] = aim;
                }

                arrCount += num - 1;
            }


        }


        return arr;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String str = "i am a student dfsdlflsdfs sdfsdfsd sdfsdfsdfsd kk r e e 额 !";
        char[] arr = str.toCharArray();
        System.out.println(replace(arr, ' ', 2, '#'));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
