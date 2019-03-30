package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class work2 {
    public static int twoPartSearch(int[] arr, int S) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            if (arr[middle] == S) {
                return middle;
            } else if (arr[middle] > S) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }

        return -1;
    }

    public static int recursiveSearch(int[] arr, int S, int le, int ri) {
        if(arr == null){
            return  -1;
        }
        if (le <=ri) {
            int minddle = (le + ri) / 2;
            if (arr[minddle] == S) {
                return minddle;
            } else if (arr[minddle] < S) {
                recursiveSearch(arr, S, le, minddle - 1);
            } else if (arr[minddle] > S) {
                recursiveSearch(arr, S, minddle + 1, ri);
            }

        }


        return -1;
    }

    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);
        final int NUM = 100;
        int[] arr = new int[]{1, 4, 5, 7, 8, 9};
//        for (int i = 0; i < NUM; i++) {
//            arr[i] = i;
//        }
        System.out.println("请输入要查找的数:");
        int S = scanner.nextInt();
        int num = twoPartSearch(arr, S);
        // int num =  recursiveSearch(arr,S,0,arr.length-1);
        if (num < 0) {
            System.out.println("未找到");
        } else {
            System.out.println(num);
        }
        Arrays.binarySearch(arr,2);
    }
}
