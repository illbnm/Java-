package Bank;
//跨行转账： GS:111       NH:111
//转账：

import java.util.Scanner;

public class ATM {
    private Bank bank;
//    private Bank bankGS;
//    private Bank bankNH;

    public ATM() {
        bank = new Bank();
    }

    private BankCard searchCard(int id, int passwd) {
        BankCard[] arr = bank.getCards();
        for (int i = 0; i < bank.getSize(); i++) {
            if (arr[i].getId() == id && arr[i].getPasswd() == passwd) {
                return arr[i];
            }
        }
        return null;
    }

    private BankCard login(int id, int passwd) {//id passwd
        return searchCard(id, passwd);
    }

    private boolean register(int id, int passwd) {
        if (searchCard(id, passwd) != null) {
            return false;
        }
        BankCard card = new BankCard(id, passwd);
        bank.add(card);
        return true;
    }

    public BankCard searchCardNum(int cardNum) {

        return null;
    }

    public BankCard debitMoney(int cardNum) {
        if (searchCardNum(cardNum) != null) {
            return searchCardNum(cardNum);
        }
        return null;
    }

    private void loginSuccessOperator(BankCard card) {
        while (true) {
            System.out.println("1.存钱 2.取钱 3.查余额 4.转账 5.退卡");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 5) {
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("输入存款金额：");
                    int money = scanner.nextInt();
                    card.saveMoney(money);
                    break;
                case 2:
                    System.out.println("请输入取款金额：");
                    money = scanner.nextInt();
                    card.withdraw(money);
                    break;
                case 3:
                    System.out.println("余额:" + card.getMoney());
                    break;
                case 4:
                    System.out.println("请输入转账的卡号:");
                    int cardNum = scanner.nextInt();

                    break;
            }
        }
    }

    public void operator() {
        while (true) {
            System.out.println("1 登陆 2注册 3退出");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 3) {
                return;
            }
            System.out.println("请输入账号：");
            int id = scanner.nextInt();
            System.out.println("请输入密码：");
            int passwd = scanner.nextInt();
            switch (choice) {
                case 1:
                    BankCard card = login(id, passwd);
                    if (card != null) {
                        loginSuccessOperator(card);
                    } else {
                        System.out.println("登陆失败");
                    }
                    break;
                case 2:
                    if (register(id, passwd)) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("注册失败");
                    }
                    break;
            }
        }
    }
}
