package src.多线程;

/**
 *  类和接口本身的差距
 *  类只能单继承 ,接口可以继承多个
 */
public class Runable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runable r = new Runable();
        Thread thread = new Thread(r);
        thread.start();
    }
}
