package src.com.libraryManage;

import java.util.Scanner;

public class library {
    private Manages manages = new Manages();
    private Books books = new Books();
    private Students students = new Students();
    Scanner scanner = new Scanner(System.in);

    public int mainDisplay(int flag) {

        int chose;
        System.out.println("1.登陆");
        System.out.println("2.注册");
        chose = scanner.nextInt();
        if (chose == 1 || chose == 2) {
            return chose;
        } else {

            return 0;
        }
    }

    public boolean login(int flag) {
        System.out.println("请输入你的ID和密码：");
        int ID = scanner.nextInt();
        int passwd = scanner.nextInt();
        if(flag == 1){
           return students.LogIn(ID,passwd);
        }
        if(flag == 2){
            return manages.LogIn(ID,passwd);
        }
        return false;
    }

    public void function(int flag) {
        while (true) {
            int chose = mainDisplay(flag);
            if (chose == 0) {
                System.out.println("输入有误！");
            }

            if (flag == 1&&chose == 1&&login(1) ==true) {
                    System.out.println("1.查询");
                    System.out.println("2.借书");
                    System.out.println("3.还书");

            }


        }

    }


}
