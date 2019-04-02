package com.bankCard;

import javax.smartcardio.Card;
import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class cardManage {
    class card {
        char[] ID = new char[18];
        char[] name = new char[5];
        int[] cardNum = new int[15];
        private int passwd;
        private double money = 0;

        card(char[] ID, char[] name, int[] cardNum, int passwd) {
            this.cardNum = cardNum;
            this.passwd = passwd;
            this.ID = ID;
            this.name = name;
        }

        public boolean confirm(int[] cardNum, int passwd) {
            if (this.cardNum.equals(cardNum) && this.passwd == passwd) {
                return true;
            }
            return false;
        }

        public double getMoney(double num) {
            if (num > 0 && num <= this.money) {
                this.money -= num;
                return money;
            }
            return -1;
        }

        public double saveMoney(double num) {
            if (num > 0) {
                this.money += num;
                return this.money;
            }
            return -1;
        }

        public int debitCard(card[] Card, int[] debitCardNum, int flag, int cardlist, double money) {

            for (int i = 0; i < cardlist; i++) {
                if (Card[i].cardNum.equals(debitCardNum)) {
                    if (Card[flag].money < money) {
                        return -1;
                    } else {
                        Card[flag].money -= money;
                        Card[i].money += money;
                        return 1;
                    }
                }
            }
            return -1;
        }

        public boolean backCard() {
            //此处操作对象数组前移
            return true;
        }

    }

    public boolean register(card[] Card, int cardlist) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****欢迎注册*****");
        System.out.println("请输入你的身份证号:");
        String ID_s = scanner.next();
        if (ID_s.length() != 18) {
            return false;
        }
        char[] ID = ID_s.toCharArray();
        System.out.println("请输入你的姓名:");
        String name_s = scanner.next();
        char[] name = new char[5];
        name = name_s.toCharArray();

        System.out.println("请输入你的密码(六位数字):");
        int passwd_First = scanner.nextInt();
        System.out.println("请确认你的密码,再输一次");
        int passwd_Second = scanner.nextInt();
        while (passwd_First != passwd_Second) {
            System.out.println("请输入你的密码(六位数字):");
            passwd_First = scanner.nextInt();
            System.out.println("请确认你的密码,再输一次");
            passwd_Second = scanner.nextInt();
        }
        int[] card = new int[15];
        double money = 0;
        if (passwd_First == passwd_Second && passwd_First > 0) {
            System.out.println("这是给您生成的卡号:");
            for (int i = 0; i < 15; i++) {
                card[i] = random.nextInt(9);
                card[0] = 6;
                System.out.print(card[i]);
            }
            System.out.println("");
            System.out.println("恭喜你,注册成功!");
            return true;
        }
        Card[cardlist] = new card(ID, name, card, passwd_First);
        return false;
    }

    public boolean login(card[] Card, int cardlist) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****欢迎登录*****");
        System.out.println("请输入你的卡号:");
        String str = scanner.next();
        int[] cardNUM = new int[15];
        for (int i = 0; i < str.length(); i++) {
            cardNUM[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        System.out.println("请输入你的密码:");
        int passwd = scanner.nextInt();
        int flag = -1;
        for (int i = 0; i < cardlist; i++) {
            if (Card[i].confirm(cardNUM, passwd)) {
                flag = i;
            }
        }
        if (flag != -1) {
            while (true) {
                System.out.println("恭喜你,登陆成功!");
                System.out.println("请输入你的选择:");
                System.out.println("1.存钱");
                System.out.println("2.取钱");
                System.out.println("3.转账");
                System.out.println("4.退卡");
                System.out.println("0.退出");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("请输入你要存的钱数:");
                        double money = scanner.nextInt();
                        double M = Card[flag].saveMoney(money);
                        if (M != -1) {
                            System.out.println("存钱成功!您的余额为:" + M);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("请输入你要取的钱数:");
                        double money = scanner.nextInt();
                        double M = Card[flag].getMoney(money);
                        if (M != -1) {
                            System.out.println("取钱成功!您的余额为:" + M);
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("请输入你要转账的卡号:");
                        String arr = scanner.next();
                        int[] debitCardNUM = new int[15];
                        for (int i = 0; i < str.length(); i++) {
                            cardNUM[i] = Integer.parseInt(str.substring(i, i + 1));
                        }
                        double money = scanner.nextInt();
                            Card[flag].debitCard( Card,debitCardNUM,flag,cardlist,money);
                        break;
                    }
                    case 4: {
                        System.out.println("退卡操作,不可逆转,请谨慎操作!");
                        if (Card[flag].backCard()) {
                            System.out.println("退卡成功!");
                        }
                        break;
                    }
                    case 0:{
                        break;
                    }
                    default: {
                        System.out.println("请检查你的输入!");

                    }
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        cardManage M = new cardManage();
        final int NUM = 100;
        int cardNum = 0;
        card[] C = new card[NUM];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你的操作");
            System.out.println("1.注册");
            System.out.println("2.登陆");
            System.out.println("0.退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0: {
                    return;
                }
                case 1: {
                    if (M.register(C, cardNum)) {
                        cardNum++;
                    }
                    break;
                }
                case 2: {
                    M.login(C, cardNum);
                    break;
                }
                default: {
                    System.out.println("请检查你的输入!");
                }
            }


        }
    }
}
