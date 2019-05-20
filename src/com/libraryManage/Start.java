package src.com.libraryManage;


import java.util.Scanner;

enum chose {
    学生, 管理员;
}

public class Start {

    static public void login(int flag) {
        if (flag != 1 && flag != 2) {
            System.out.println("请检查你的输入! ");
        }
        if (flag == 1) {


        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("图书管理系统");
        while (true) {
            System.out.println("1.学生");
            System.out.println("2.管理员");
            int Chose = scanner.nextInt();
            int flag = 0;
            switch (Chose) {
                case 1: {
                    flag = 1;

                }
                break;

                case 2: {
                    flag = 2;
                }
                break;
                default:
                    System.out.println("输入有误!!");
                    break;
            }
            login(flag);
        }
    }
}
