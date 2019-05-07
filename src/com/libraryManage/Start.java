package src.com.libraryManage;



import java.util.Scanner;

enum chose {
    学生, 管理员;
}

public class Start {
    static public void login(String flag) {
        if (flag == "学生") {

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("图书管理系统");
        while (true) {
            System.out.println("1.学生");
            System.out.println("2.管理员");
            int Chose = scanner.nextInt();
            String flag = "";
            switch (Chose) {
                case 1: {
                    flag = "学生";
                }
                break;

                case 2: {
                    flag = "管理员";
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
