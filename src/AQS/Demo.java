package src.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {
    private int m = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public int next() {
        lock.readLock();
        try {
            TimeUnit.SECONDS.sleep(2);
            return m++;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR");
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Thread[] th = new Thread[20];
        for (int i = 0; i < 20; i++) {
            th[i] = new Thread(() -> {
                System.out.println(demo.next());
            });
            th[i].start();
        }
    }
}
