package src.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  可以创建具有返回值的子进程
 *
 */
public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 45;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
         CallableTest callableTest = new CallableTest();
         FutureTask<Integer> task ;
         Thread thread = new Thread(task = new FutureTask<>(callableTest));
         thread.start();
        System.out.println(task.get());
    }
}
