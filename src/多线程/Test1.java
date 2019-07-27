package src.多线程;

import java.util.concurrent.Callable;

public class Test1 extends Thread {
    @Override
    public void run() {

        super.run();
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getState());
    }

    public static void main(String[] args) {
       // Test1 thread = new Test1();
        //thread.setName("普通线程");
        Test1 newthread = new Test1();

        newthread.setDaemon(true);
        newthread.setName("守护线程");
        System.out.println("守护线程"+ newthread.getPriority());
        newthread.start();
        for (int i = 0; i < 20; i++) {
            Test1 test1 = new Test1();
            test1.setName("普通线程");
            System.out.println(test1.getPriority());
            test1.start();

        }



    }
}
