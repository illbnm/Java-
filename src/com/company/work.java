package com.company;


import java.*;
import java.util.Scanner;

public class work {
    public int getSum(int n, int a) {
        int SUM = 0;
        int A = 0;
        for (int i = 1; i <= n; i++) {
            A = A * 10 + a;
            SUM += A;
        }
        return SUM;
    }

    public int getDaffodil(int[] arr) {
        int size = 0;                        //获取水仙花
        for (int i = 100; i <= 999; i++) {
            int B = i / 100;
            int G = (i - B * 100) / 10;
            int S = i % 10;

            if (B * B * B + G * G * G + S * S * S == i) {
                arr[size] = i;
                size++;
            }
        }
        return size;
    }

    public static void main(String[] argc) {
        work Get = new work();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. S=a+aa+aaa+aaaa+aaaaa; 2.获取水仙花数 c 3.      5位整数的输出    0 .退出  ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0: {
                    break;
                }
                case 1: {
                    /**
                     * 1.
                     * n是由键盘输入，例如：n=5;  S=a+aa+aaa+aaaa+aaaaa;
                     */

                    System.out.println("S = a + aa + aaa +......");


                    System.out.println("请输入你要n的值,和a的值");
                    int n = scanner.nextInt();
                    int a = scanner.nextInt();
                    System.out.println("SUM的值为:" + Get.getSum(n, a));
                    break;
                }
                case 2: {
/**
 * 2输出所有的水仙花数，所谓水仙花数始值一个3位数，其各种数字立方和等于该本身，例如：153是一个水仙花数。
 */System.out.println("输出结果为:");
                    int arr[] = new int[100];
                    for (int i = 0; i < Get.getDaffodil(arr); i++) {
                        System.out.println("第" + i + "个水仙花数为:" + arr[i]);

                    }
                    break;
                }
                /**
                 * 3.
                 * 给一个不多于5位的正整数，要求：
                 * ①输出它是几位数
                 * ②分别输出每一位数字
                 * ③按逆序输出各位数字，例如原数为321，应输出123
                 */
                case 3: {
                    System.out.println("请输入五位的正整数");
                    String num = scanner.next();
                    char[] NUM = num.toCharArray();
                    System.out.println("这个数为" + NUM.length + "位数");
                    System.out.println("每一位为");
                    for (int i = 0; i < NUM.length; i++) {
                        System.out.println(" " + NUM[i] + " ");
                    }
                    System.out.println("逆序输出为:");
                    for (int i = NUM.length - 1; i >= 0; i--) {
                        System.out.println("  " + NUM[i] + "  ");

                    }
                    break;
                }
                default: {
                    System.out.println("输入错误,请检查你的输入!");
                }
            }
        }
    }
}
