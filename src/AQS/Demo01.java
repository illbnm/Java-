package src.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo01 {
    private int m = 0;
    private MyLock loc = new MyLock();
    private ReentrantLock lock = new ReentrantLock(true);

    public int next() {
        lock.lock();
        try {
            return m++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo01 demo = new Demo01();
        Thread[] th = new Thread[20];
        for (int i = 0; i < 20; i++) {
            th[i] = new Thread(() -> {
                System.out.println(demo.next());
            });
            th[i].start();
        }
    }
}
