package src.多线程;

import java.util.concurrent.CountDownLatch;

class syThread extends Thread {
    private volatile static int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int my) {
        money = my;
    }

    @Override
    public void run() {
        super.run();
        addMoney();
//        for (int i = 0; i < 10000; i++) {
//            money++;
//        }
    }


    public synchronized static void addMoney() {
        for (int i = 0; i < 1000; i++) {
            money++;
        }
        System.out.println(money);
    }


}

public class 转账 {


    public static void main(String[] args) {
       // CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            syThread thread = new syThread();
            thread.start();
        }
        syThread newthread = new syThread();
        System.out.println(newthread.getMoney());
    }

}
