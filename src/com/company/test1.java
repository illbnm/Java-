package com.company;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class test1 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (A[i] % 2 != 0 && i < j) {
                i++;
            }
            while (A[j] % 2 == 0 && j > i) {
                j++;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;


        }

        return A;
    }

    public static void main(String[] argc) {
//    int []arr ={1,2,3};
//    brr =arr.clone();
//    arr = Arrays.copyOf(arr,arr.length*2);
//    System.out.println("arr:"+ Arrays.toString(arr));
//    System.out.println("brr:"+ Arrays.toString(brr));

        /*   int []arr = {1,2,3,4,5,6,7,8,9};*/
        int[] arr = {1, 3, 5};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 == 0) {
                for (int j = arr.length - 1; j >= i; j--) {
                    if (arr[j] % 2 != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (arr[i] % 2 != 1) {     //保存i为偶数的位置
                i++;
            }
            //保存j为奇数的位置
        }


    }


}
