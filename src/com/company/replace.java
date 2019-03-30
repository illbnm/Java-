package com.company;

import java.util.Arrays;

public class replace {
    //    public static int getBlankCount(char []arr){
//        int num ;
//
//        return num ;
//    }
//    public static char  replaceChar(char []arr,char value){
//        int count = getBlankCount(arr);
//        Arrays.copyOf(arr,arr.length+count);
//
//    }
//    public static void main(String[] args) {
//
//    }
    public static int getBlankCount(char[] arr) {
        int blankCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                blankCount++;
            }
        }
        return blankCount;
    }

    public static char[] replace(char[] arr) {
        if (arr == null)
            return null;

        //1.扩容
        int blankCount = getBlankCount(arr);
        arr = Arrays.copyOf(arr, arr.length + blankCount);
        //2.找空格
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                //3.移动数据
                arr[i] = '#';
                for (int j = arr.length - blankCount - 1; j > i; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = '#';
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String str = "i am a student";
        char[] arr = str.toCharArray();
        arr = replace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
