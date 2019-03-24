package com.test;

import java.math.*;
import java.util.Random;
import java.util.Scanner;

/**
 * 1.随机数
 * 2.猜价格
 * 猜 三次机会 机会用完/才对 是否进行下一轮游戏
 */

public class 猜数字 {
   /* public int GetRandom() {
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        return num;
    }*/

    public int GucessNum() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(100);
        int num = random.nextInt(100) +1;

        System.out.println(num);
        for (int i = 0; i < 3; i++) {
            int Guss = scanner.nextInt();
            if (Guss == num) {
                break;
            } else {
                System.out.println(num);
                System.out.println("不好意思,答案错误!");
                if (i == 2) {
                    System.out.println("三次机会已用完!");
                    System.out.println("要猜的数字是" + num);
                    return 0;
                }

            }
            if (Guss > num) {
                System.out.println("大了");
            } else {
                System.out.println("小了");
            }
        }
        System.out.println("恭喜你猜对了");
        return 0;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        com.company.猜数字 cai = new com.company.猜数字();
        while (true) {
            System.out.println("猜数字小游戏");
            System.out.println("请输入你要猜的数字");
            System.out.println(cai.GetRandom());
            cai.GucessNum(cai.GetRandom());
            System.out.println("结束请输入 1 ,重来输入 2");
            int num = scanner.nextInt();
            if (num == 1) {
                break;
            }


        }

    }
}