package src.SemaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarDemo {

    public static void main(String[] args) {
        //创建Semaphore

        Semaphore sp = new Semaphore(5);

        //请求许可
        Thread[] car = new Thread[10];
        for (int i = 0; i < 10; i++) {
            car[i] = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    sp.acquire();
                    System.out.println(Thread.currentThread().getName() + "可以进停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //使用资源
                try {
                    int n;
                    TimeUnit.SECONDS.sleep(n = new Random().nextInt(10));
                    System.out.println("停车时间 : " + n);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 释放资源
                try {
                    sp.release();
                    System.out.println(Thread.currentThread().getName() + "离开停车场");
                } catch (Exception e) {

                }

            });

            car[i].start();
        }


    }

}
