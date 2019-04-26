package com.leetcode;

import java.util.Scanner;

public class Fibonacci {
   public  int getFibonacci(int value){
        int []arr = new int[value];
        arr[0] = 1 ;
        arr[1] = 1;
        int i = 3 ;
        int n = 1 ;
        int nnext = 1 ;
//        while(i<value){
//            arr[i] = arr[i-1]+arr[i-2];  //用数组要开辟空间 空间复杂度变大
//            i++;
//        }
return arr[value-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            Fibonacci A = new Fibonacci();
        System.out.println(A.getFibonacci(scanner.nextInt()));
    }
}
