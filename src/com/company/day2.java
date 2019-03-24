package com.company;

import java.util.Scanner;
import java.math.*;

public class day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*
        int Grade = scanner.nextInt();
        if (Grade >= 80 && Grade <= 100) {
            System.out.println("等级为A");
        }
        if (Grade >= 70 && Grade < 80) {
            System.out.println("等级为B");
        }
        String G = scanner.next();
        if (G.equals("A")) {
            System.out.println("leavel等级是A,评分标准为:80~100");
        }
        if (G.equals("B")) {
            System.out.println("leavel等级是A,评分标准为:70~80");
        }
        switch (G) {
            case "A":

        }*/
      /*  int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);
*/
        /**
         * 判断素数
         */
       int n = scanner.nextInt();
       int i ;
        for ( i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println("不是素数");
                break;
            }
        }
        if( n  == i  ){
            System.out.println("是素数");
        }

  /*  for (int i = 2; i <= 100; i++) {
            for (int j = 2; j<=i; j++) {
                if (i % j == 0) {
                    break;
                }

                if(j>i){
                    System.out.println(i);
                }
            }
        }

*/
/**
 * 2.输出一组数
 */
   /*     int n;
        n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            double s = Math.pow(-1, i + 1);
            int a = (int) s;
            sum += a * (1 / i);
        }
        System.out.println(sum);

*/
 /*
 int year  = scanner.nextInt();
 if(year % 4 ==0 && year %100 !=0){
     System.out.println("是闰年");
 }
 else if(year%100==0 && year %400 ==0)
 {
     System.out.println("是闰年 ");
 }
 else
 {
     System.out.println("不是闰年");
 }
*/

    }
}
