package src.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReThread extends Thread {
    private static int money;
    private CountDownLatch latch;
    private static Lock lock = new ReentrantLock();

    public ReThread(CountDownLatch latch) {
        this.latch = latch;
    }

    public ReThread() {

    }


    @Override
    public void run() {

        addMoney();
//        latch.countDown();
    }

    private void addMoney() {
//        lock.lock();//阻塞的获取锁的方式

//        if (lock.tryLock()) {
//        boolean b = false;
//        try {
//            b = lock.tryLock(7,TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (b) {
//defer lock.unlock();
        try {
            lock.lockInterruptibly();//阻塞
            System.out.println(this.getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        for (int i = 0; i < 10000; i++) {
//            money++;
//        }
            lock.unlock();
//        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static int getMoney() {
        return money;
    }
}

public class ReTest {

    public static void main(String[] args) {
//        CountDownLatch latch = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            ReThread thread = new ReThread(latch);
//            thread.start();
//        }
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(ReThread.getMoney());
        ReThread thread = new ReThread();
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReThread thread1 = new ReThread();
        thread1.start();
    }
}
