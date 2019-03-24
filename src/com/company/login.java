package com.company;

import com.sun.javafx.image.BytePixelSetter;
import org.omg.CORBA.FREE_MEM;

import java.util.Scanner;                   //switch s

// ize

public class login {
    public boolean cancel(int arr[], int size, int num) {
        boolean flag = false;
        int to = 0;
        for (int i = 0; i <= size; i++) {
            if (arr[i] == num) {
                arr[i] = 0;
                to = i;
                for (int j = i; j <= size; j++) {
                    arr[j] = arr[j + 1];
                }
                flag = true;
                return flag;
            }
        }
        return flag;
    }

    public boolean loginnum(int arr[], int num, int size) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == num) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean register(int arr[], int num, int size) {
        boolean flag = false;
        /*if (this.loginnum(num))    //账号已存在
        {
            flag = false;
            return flag;
        }*/
        for(int i = 0 ;i<size;i++){
            if(arr[i] == num){
                flag =false;
                return flag;
            }
        }
        int sign = 1;
        int change = 0;
        for (int i = 0; i <= size; i++) {

            if (arr[i] == 0) {
                sign = 0;
            }
        }
        if (sign == 1) {
            int[] arr2 = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {     //复制

                arr2[i] = arr[i];
            }
            change = 1;
        }

        for (int i = 0; i < num; i++) {
            if (arr[i] == 0) {
                arr[i] = num;
                flag = true;
                return flag;
            }
        }
        return flag;

    }

    public static void main(String[] argc) {
        int size = 0;
        int NUM = 10;
        int arr[] = new int[NUM];
        Scanner scanner = new Scanner(System.in);
        login A = new login();

        while (true) {
            System.out.println("请输入您的选择");
            System.out.println("1.登陆 2注册 3注销 0退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("请输入账号:");
                    int num = scanner.nextInt();
                    A.loginnum(arr, num, size);
                    if (A.loginnum(arr, num, size)) {
                        System.out.println("登陆成功");
                    } else {
                        System.out.println("登录失败");
                    }
                }
                break;
                case 2: {
                    System.out.println("请输入注册账号");
                    int num = scanner.nextInt();
                    if (A.register(arr, num, size)) {
                        System.out.println("注册成功");
                        size++;
                    } else {
                        System.out.println("注册成功");
                    }

                    break;
                }
                case 3: {
                    System.out.println("输入要注销的账号");
                    int num = scanner.nextInt();
                    if (A.cancel(arr, size, num)) {
                        System.out.println("注销成功");
                        size--;
                    }else
                    {
                        System.out.println("注销失败");
                    }

                    break;
                }
                default: {
                    System.out.println("输入有误");
                }
            }
            if (size >= NUM) {
                NUM = arr.length*2;
                int brr[] = new int[NUM];
                for (int i = 0; i < NUM; i++) {
                    brr[i] =arr[i];

                }

            }
        }


    }
}
