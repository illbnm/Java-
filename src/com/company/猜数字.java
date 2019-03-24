package com.company;

import java.math.*;
import java.util.Random;
import java.util.Scanner;

/**
 * 1.随机数
 * 2.猜价格
 * 猜 三次机会 机会用完/才对 是否进行下一轮游戏
 */

public class 猜数字 {
    public int GetRandom() {
        Random random = new Random();
        int num = random.nextInt();
        return num;
    }

    public int GucessNum(int random) {
        Scanner scanner = new Scanner(System.in);
        int Random = random;
        for (int i = 0; i < 3; i++) {
            int Guss = scanner.nextInt();
            if (Guss == Random) {
                break;
            } else {
                System.out.println("不好意思,答案错误!");
                if (i == 2) {

                    System.out.println("三次机会已用完!");
                    return 0;
                }

            }
        }
        System.out.println("恭喜你猜对了");
        return 0;
    }

    public static void main(String[] args) {
            猜数字 cai = new 猜数字();
            while (true){
                    System.out.println("请输入你要猜的数字");
                cai.GucessNum(cai.GetRandom());


            }

    }
}
