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
        if (arr == null) {
            return null;
        }
        //1.扩容
        int blankCount = getBlankCount(arr);
        arr = Arrays.copyOf(arr, arr.length + blankCount);
        //2.找空格
        int count= 0 ;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                //3.移动数据
                arr[i] = '#';
                for (int j = arr.length - 1 - blankCount+count; j > i; j--) {  //相对的最后   尾巴一直在变
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = '#';
                count ++ ;
            }
        }
        return arr;
    }

    public  static char replaceAll(char []str ,int src,int num ){
        int count ;

return 0 ;
    }
    public static void main(String[] args) {
        String str = "i am a student";
        char[] arr = str.toCharArray();
        arr = replace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
