package src.并发集合;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConllectionDemo01 {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque();
        //添加数据
        Thread[] add = new Thread[100];

        for (int i = 0; i < 100; i++) {
            add[i] = new Thread(() -> {

                for (int j = 0; j < 10000; j++) {
                    list.add(Thread.currentThread().getName() + "ELEMENT : " + j);

                }
            });
            add[i].start();
            try {
                add[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("after add" + list.size());


        //移除数据
        Thread[] poll = new Thread[100];

        for (int i = 0; i < 100; i++) {
            poll[i] = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    list.pollLast();
                    list.pollFirst();
                }

            });
            poll[i].start();
            try {
                poll[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("after poll" + list.size());


    }
}
