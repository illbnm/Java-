package src.ThreadPool;

import java.util.concurrent.TimeUnit;

public class FixDemo  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
