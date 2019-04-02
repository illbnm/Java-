package com.company;


import java.util.Arrays;

public class replace2 {
    public static int getSrcCount(char[] arr, char src) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == src) {
                count++;
            }
        }
        return count;
    }

    public static char[] replace(char[] arr, char src, int num, char aim) {
        if (arr == null)
            return null;

        //1.扩容 i am
        int srcCount = getSrcCount(arr, src);
        arr = Arrays.copyOf(arr, arr.length + srcCount * (num - 1));
        //2.找src
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == src) {
                //3.移动数据
                arr[i] = aim;
//                for (int j = arr.length - srcCount - 1 + count; j > i; j--) {                                      //将数组向后移动
//                    arr[j + num-1 ] = arr[j];
//                }
                for(int j = arr.length-1 ;j>i ;j--){
                    arr[j] = arr[j-num];
                }
//                 arr[i + 1] = aim;
                //for...
                for(int k = i+1;k<=+num;k++ ){
                    arr[k] = aim;
                }

                count += (num - 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String str = "i am a";
        char[] arr = str.toCharArray();
        arr = replace(arr, 'a', 2, 'a');
        System.out.println(Arrays.toString(arr));

    }
}