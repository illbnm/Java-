package Bank;
//跨行转账： GS:111       NH:111
//转账：

import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Bank bankGS;
    private Bank bankNH;

    public ATM() {
        bank = new Bank();
        bankGS = new Bank();
        bankNH = new Bank();
    }

    private BankCard searchCard(int id, int passwd, String SSbank) {
        if (SSbank.equals("nh")) {
            BankCard[] arr = bankNH.getCards();
            for (int i = 0; i < bankNH.getSize(); i++) {
                if (arr[i].getId() == id && arr[i].getPasswd() == passwd) {
                    return arr[i];
                }
            }
        } else {

            BankCard[] arr = bankGS.getCards();
            for (int i = 0; i < bankGS.getSize(); i++) {
                if (arr[i].getId() == id && arr[i].getPasswd() == passwd) {
                    return arr[i];
                }
            }
        }
        return null;
    }

    private BankCard login(int id, int passwd, String SSbank) {//id passwd
        return searchCard(id, passwd, SSbank);
    }

    private boolean register(int id, int passwd, String SSbank) {
        if (searchCard(id, passwd,SSbank) != null) {
            return false;
        }
        if (SSbank.equals("nh")) {
            BankCard card = new BankCard(id, passwd);
            bankNH.add(card);
        } else {
            BankCard card = new BankCard(id, passwd);
            bankGS.add(card);
        }
        return true;
    }

    public BankCard searchCardNum(int cardNum, String SBank) {
        if (SBank.equals("nh")) {
            BankCard[] arr = bankNH.getCards();
            for (int i = 0; i < bankNH.getSize(); i++) {
                if (arr[i].getId() == cardNum)
                    return arr[i];
            }
        } else {
            BankCard[] brr = bankGS.getCards();
            for (int i = 0; i < bankGS.getSize(); i++) {
                if (brr[i].getId() == cardNum) {
                    return brr[i];
                }
            }
        }

        return null;
    }

    public boolean Cunmoney(int cardNum, String SBank, BankCard card) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你要转账的金额");
        int money = scanner.nextInt();
        if (card.withdraw(money)) {
            searchCardNum(cardNum, SBank).saveMoney(money);
            return true;
        } else return false;


    }
//    public BankCard debitMoney(int cardNum) {
//        if (searchCardNum(cardNum) != null) {
//            return searchCardNum(cardNum);
//        }
//        return null;
//    }

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
                    System.out.println("输入转账银行: gs or nh");
                    String S = scanner.next();
                    System.out.println("请输入转账的卡号:");
                    int cardNum = scanner.nextInt();
                    Cunmoney(cardNum, S, card);

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
            System.out.println("请输入银行");
            String SSbank = scanner.next();
            System.out.println("请输入账号：");
            int id = scanner.nextInt();
            System.out.println("请输入密码：");
            int passwd = scanner.nextInt();
            switch (choice) {
                case 1:
                    BankCard card = login(id, passwd, SSbank);
                    if (card != null) {
                        loginSuccessOperator(card);
                    } else {
                        System.out.println("登陆失败");
                    }
                    break;
                case 2:
                    if (register(id, passwd, SSbank)) {
                        System.out.println("注册成功");
                    } else {
                        System.out.println("注册失败");
                    }
                    break;
            }
        }
    }
}
