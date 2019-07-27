package src.多线程;

class T1 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"   " + i);
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 11; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName()+"   " + i);
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 21; i <= 30; i++) {
            System.out.println(Thread.currentThread().getName()+"   " + i);
        }
    }
}


public class 三个进程打印 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        t1.setName("T1");
        Thread t2 = new Thread(new T2());
        t2.setName("T2");
        Thread t3 = new Thread(new T3());
        t3.setName("T3");
        try {  t3.start();
            t3.join();
            t2.start();
            t2.join();
            t1.start();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
