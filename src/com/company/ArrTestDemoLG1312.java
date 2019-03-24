package com.company;

import java.util.Scanner;

public class ArrTestDemoLG1312 {
    /**
     * 数组：40字节
     * 相同数据类型的集合
     * 连续空间
     *
     */

    public static boolean login(int[] message,int id,int size){
        for(int i=0;i<size;i++){
            if(message[i] == id){
                return true;
            }
        }
        return false;
    }
    public static boolean register(int[] message,int size,int id){
        //找之前是否存在过这个id
        for(int i=0;i<size;i++){
            if(id == message[i]){
                return false;
            }
        }
        message[size] = id;
        return true;
    }
    public static void main(String[] args) {
        final int INITSIZE = 2;
        int[] message = new int[INITSIZE];

        int size = 0;//有效个数
        while (true) {
            System.out.println("请输入：1登陆 2注册 3注销 4退出");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 4) {
                return;
            }

            System.out.println("请输入账号：");
            int id = scanner.nextInt();
            switch (choice) {
                case 1:
                    if(login(message,id,size)){
                        System.out.println("登陆成功");
                    }else{
                        System.out.println("失败");
                    }
                    break;
                case 2:
                    if(register(message,size,id)) {
                        System.out.println("注册成功");
                        size++;
                    }else{
                        System.out.println("注册失败");
                    }
                    break;
                default:
                    System.out.println("输入错误");
            }
        }
    }
}
