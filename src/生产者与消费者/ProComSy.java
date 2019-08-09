package src.生产者与消费者;

import java.util.LinkedList;
import java.util.List;

class ComsumerThread extends Thread {

    private List<Integer> l;

    public ComsumerThread(List<Integer> l) {
        this.l = l;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (l) {
                while (l.isEmpty()) {
                    try {
                        l.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者 " + this.getName() + "消费一个元素");
                l.remove(0);//消费
//                l.notify();
                l.notifyAll();
            }
        }
    }
}

class ProducerThread extends Thread {
    private List<Integer> l;
    private int maxSize;

    public ProducerThread(List<Integer> l, int maxSize) {
        this.l = l;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (l) {
                while (l.size() == maxSize) {
                    try {
                        l.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者 " + this.getName() + "生产一个元素");
                l.add(1);//生产
//                l.notify();//只唤醒一个线程
                l.notifyAll();
            }
        }
    }
}

public class ProComSy {

    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        int maxSize = 10;
        for (int i = 0; i < 3; i++) {
            ComsumerThread comsumer = new ComsumerThread(l);
            ProducerThread producer = new ProducerThread(l, maxSize);
            comsumer.start();
            producer.start();
        }
    }
}
