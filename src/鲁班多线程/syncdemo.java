package src.鲁班多线程;

import javax.management.monitor.Monitor;
import java.util.concurrent.TimeUnit;

public class syncdemo {
//修饰静态方法

    public synchronized static void accessResource0() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "  " + "is runing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//修饰非静态方法

    public synchronized void accessResource1() {

        try {
            TimeUnit.MINUTES.sleep(2);
            System.out.println(Thread.currentThread().getName() + " " + "is runing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //
    public void accessResource4() {
        synchronized (syncdemo.class) {// ClassLoader class >>> 堆上  Class 对象
            // 有Class对象的所有的对象都共同使用这一个锁
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " " + "is runing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        syncdemo demo01 = new syncdemo();

        for (int i = 0; i < 5; i++) {
            new Thread(demo01::accessResource1).start();
            ;
        }


    }
}
