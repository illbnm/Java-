package com.company;

import java.util.Arrays;

public class copyTest {
    public static void main (String []argc){
        int [][]arr =new int [][] {{1,2,3},{4,5,6}};
         int [][]brr =new int [2][3] ;         //new int [2][3];
//            brr =Arrays.copyOf(arr,arr.length);
        System.arraycopy(arr,0,brr,0,arr.length);

//        brr = arr;
//        for(int i = 0;i<arr.length;i++)
//        {
//            for(int j= 0 ;j<arr[i].length;j++)
//            {
//                brr[i][j] = arr[i][j];
//            }
//        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(brr));
        System.out.println(arr[0]);
        System.out.println(brr[0]);


    }
}
