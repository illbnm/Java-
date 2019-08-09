package src.生产者与消费者;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ComsumerReThread extends Thread {

    private List<Integer> l;
    private Lock lock;
    private Condition comCondition;
    private Condition proCondition;

    public ComsumerReThread(List<Integer> l, Lock lock,
                            Condition comcondition, Condition procondition) {
        this.l = l;
        this.lock = lock;
        comCondition = comcondition;
        proCondition = procondition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (l.isEmpty()) {
                    try {
                        comCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者 " + this.getName() + "消费一个元素");
                l.remove(0);//消费
//                proCondition.signal();
                proCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}

class ProducerReThread extends Thread {
    private List<Integer> l;
    private int maxSize;
    private Lock lock;
    private Condition proCondition;
    private Condition comCondition;

    public ProducerReThread(List<Integer> l, int maxSize, Lock lock,
                            Condition procondition, Condition comcondition) {
        this.l = l;
        this.maxSize = maxSize;
        this.lock = lock;
        proCondition = procondition;
        comCondition = comcondition;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (l.size() == maxSize) {
                    try {
                        proCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者 " + this.getName() + "生产一个元素");
                l.add(1);//生产
                comCondition.signalAll();
//                comCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class ProComRee {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        int maxSize = 10;
        Lock lock = new ReentrantLock();
        Condition proCondition = lock.newCondition();
        Condition comPondition = lock.newCondition();
        for (int i = 0; i < 3; i++) {
            ComsumerReThread comsumer = new ComsumerReThread(l, lock, comPondition, proCondition);
            ProducerReThread producer = new ProducerReThread(l, maxSize, lock, proCondition, comPondition);
            comsumer.start();
            producer.start();
        }
    }
}
