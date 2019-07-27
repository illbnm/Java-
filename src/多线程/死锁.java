package src.多线程;

import com.sun.deploy.util.SyncAccess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class resourceA {
    int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class resourceB {
    int b = 0;

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.b = a;
    }
}

class ThreadA extends Thread {
    resourceA A;
    resourceB B;

    public ThreadA(resourceA A, resourceB B) {
        this.A = A;
        this.B = B;
    }

    public resourceA getA() {
        return A;
    }

    public void setA(resourceA a) {
        A = a;
    }

    public resourceB getB() {
        return B;
    }

    public void setB(resourceB b) {
        B = b;
    }

    @Override
    public void run() {
        super.run();
        Lock lock = new ReentrantLock();
        lock.lock();
        synchronized (A.getClass()) {
            System.out.println("1111111线程1获取资源A");
            int A = this.getA().a;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                System.out.println("11111线程1获取不到资源B");
                synchronized (B.getClass()) {
                    System.out.println("11111线程1获取资源B");
                    int B = this.getB().b;

                }
            }
        }
    }


}

class ThreadB extends Thread {
    resourceA A;
    resourceB B;

    public resourceA getA() {
        return A;
    }

    public void setA(resourceA a) {
        A = a;
    }

    public resourceB getB() {
        return B;
    }

    public void setB(resourceB b) {
        B = b;
    }

    public ThreadB(resourceA A, resourceB B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public void run() {
        super.run();
        synchronized (B.getClass()) {
            System.out.println("222222222线程2获取资源B");
            int B = this.getB().b;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                System.out.println("2222222线程2获取不到资源A");
                synchronized (A.getClass()) {
                    System.out.println("222222222线程2获取资源A");
                    int A = this.getA().a;
                }
            }
        }


    }

}

public class 死锁 {


    public static void main(String[] args) {
        resourceA A = new resourceA();
        resourceB B = new resourceB();
        ThreadA threadA = new ThreadA(A, B);
        ThreadB threadB = new ThreadB(A, B);

        threadA.start();
        threadB.start();

    }
}
