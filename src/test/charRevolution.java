package src.test;

import java.util.Arrays;

public class charRevolution {
    public static  void Revolution(char []arr , int begin,int end){
        int middle = (begin + end) /2 ;

        while(begin <=  middle){
            char temp = 0 ;
            temp = arr[begin];
            arr[begin] = arr[end] ;
            arr[end] = temp;
            begin++;

        }
    }
    public static void LeftRotateString(String str, int n) {
        // 将前面部分逆序
        if(n>str.length() || n< 0 )
            return ;
        char[] arr = str.toCharArray();
       Revolution(arr,0,n);
       Revolution(arr,n,arr.length-1);
       Revolution(arr,0,arr.length-1);
       str = arr.toString();
    }

    public static void main(String[] args) {
        String str = "hello";
        int n =2 ;
        LeftRotateString(str,n);
        System.out.println(str);

    }
}
