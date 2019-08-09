package src.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixPoolDemo {
    public static void main(String[] args) {


    //创建固定大小的线程池
    ExecutorService pool = Executors.newFixedThreadPool(5);
    //创建10个任务分配给pool

        for (int i = 0; i < 10; i++) {
            Runnable task = new FixDemo();
            //给线程池分配任务
            pool.execute(task);
        }

        pool.shutdown();
    }

}
