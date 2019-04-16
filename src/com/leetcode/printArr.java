package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class printArr {
    public static int[][] Print(int[][] arr) {
        int[][] brr = new int[arr.length][arr[0].length];
        int clounms = arr[0].length;
        int rows = arr.length;
        int start = 0;
        while (start * 2 < clounms && start * 2 < rows) {
            int endx = rows - start - 1;                                                    //打印的终止行号
            int endy = clounms - start - 1;                                                  //打印的终止列号
            System.out.println("endx" + endx + "endy" + endy);
            for (int i = start; i <= endx; i++) {
                System.out.println(arr[start][i]);  //打印第一行
            }
            if (start < endy) {
                for (int i = start + 1; i <= endy; i++) {
                    System.out.println(arr[i][endx]); // 打印右边的一行
                }
            }
            if (start < endy && start < endx) {
                for (int i = endy - 1; i >= start; i--) {
                    System.out.println(arr[endy][i]);
                }
            }
            if (endy - 1 > start && endx > start) {
                for (int i = endy - 1; i >= start + 1; i--) {
                    System.out.println(arr[i][start ]);
                }
            }

            start++;
        }


        return arr;
    }


    public static void main(String[] args) {
        /**
         * clounms 为列号
         * rows 为行号
         *
         */
        int[][] arr = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.println(arr[i][j]);
//            }
//        }
        Print(arr);
    }
}
