package src.com.bankCard;

import java.util.Scanner;

public class ATM {
    private Bank bank = new Bank();

    public void operator() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.注册    2.登陆    0.退出");
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
        }
    }
}
