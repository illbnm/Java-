package com.company;

import java.util.Arrays;
import java.*;
import java.util.Scanner;

public class leetcode {
    public static String replaceSpace(StringBuffer str) {
        String brr = new String();
        char[] arr = new char[str.length()];
        brr = str.toString();
        arr = brr.toCharArray();
        int len = arr.length;
        String insert = "%20";
        String[] arrChar = new String[len];
        for (int i = 0; i < arr.length; i++) {
            arrChar[i] = String.valueOf(arr[i]);
            if (arr[i] == ' ') {
                arrChar[i] += insert;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            brr += arrChar[i];
        }
        System.out.println(brr);
        return brr;
    }

    //    public  String inSert(String []arr){
//        int num = arr.length;
//        char []brr ;
//        brr = arr.toCharArray();
//
//
//
//        return " ";
//    }

    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);
        String arr = " i am a student ";
        int num = arr.length();
        char[] brr = new char[num];
        String result[] = new String[num];
        brr = arr.toCharArray();
        System.out.println(Arrays.toString(brr));

        int right = num;
        int i = 0;
        String replace;
        String rep =new String();
        int number;
        String sub = new String();
        System.out.println("请输入要替换的符号和个数:");
        replace = scanner.nextLine();
        number = scanner.nextInt();
        for(int j = 0 ;j< number;j++){

           rep += replace;
        }
System.out.println(replace);
        while (i < right) {
            result[i] = String.valueOf(brr[i]);
            char[] re = result[i].toCharArray();
            if (re[0] == ' ') {
                result[i] = String.valueOf(rep);
            }
//            if (brr[i] == ' ') {
//                brr[i] = '#';
            sub += result[i];
            i++;
        }
        System.out.println(sub);

    }
}
