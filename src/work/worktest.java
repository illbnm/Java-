package work;

import java.util.Arrays;
import java.util.Scanner;


public class worktest {
    public static int getOne(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            int status = i;
            while (status != 0) {
                if (status % 10 == 1) {
                    count++;
                    status = status / 10;
                } else {
                    status = status / 10;
                }
            }
        }
        return count;
    }

    public static int print(int[][] num) {
        int left = 0;
        int right = num[0].length;
        int up = 0;
        int down = num.length ;
        int flag = 0;
        while (left <= right && up <= down) {
            if (left < right && up < down) {
                for (; left < right; left++) {

                    System.out.println(num[up][left]);
                }

            }
            if (left-1 == (right-1)  && up < down) {
                for (; up < down; up++) {
                    System.out.println(num[left][up]);
                }
            }
            if (left <= right && up == down) {
                for (; left >= 0; left--) {
                    System.out.println(num[down][left]);
                }
            }
            if (left == right && up <= down) {
                flag++;
                for (; up >= flag; up--) {
                    System.out.println(num[up][right]);

                }
            }

        }
        return 0;

    }

    public static char[] reversion(String arr) {
        char[] brr = arr.toCharArray();
        char[] str = new char[arr.length()];
        int left = 0;
        int right = arr.length() - 1;
        int str_r = str.length - 1;
        for (int i = 0; i < brr.length; i++) {
            if (brr[i] == ' ') {
                right = i;
                for (int k = i; k >= left; k--) {
                    str[str_r] = brr[k];
                    str_r--;
                }


                left = i + 1;
            }
            System.out.println(Arrays.toString(str));
        }

        return str;
    }

    public static void main(String[] args) {
        /**
         * 判断一的个数
         */
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入整数n");
//        int num = scanner.nextInt();
//        int count = getOne(num);
//        System.out.println(count);
        //***********************************//
        /**
         * 打印矩阵
         */int s = 1;
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                //int value = scanner.nextInt();
                arr[i][j] = s++;


            }
        }

        print(arr);

        //*****************************//
        /**
         * 反转句子
         */
//        String str = "i am a student !";
//        System.out.println(Arrays.toString(reversion(str)));

    }
}
