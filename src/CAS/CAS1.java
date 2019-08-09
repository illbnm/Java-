package src.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS1 {
    private static volatile  int m = 0 ;
    private  static AtomicInteger atomicI = new AtomicInteger(0);

    public static void increase(){
        m++ ;
    }
    public static void increase1(){
        atomicI.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread threads[] = new Thread[20] ;
        for (int i = 0; i <20 ; i++) {
            threads[i] = new Thread(()->{
                CAS1.increase();
            });
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(m);
        Thread thread[] = new Thread[20] ;
        for (int i = 0; i <20 ; i++) {
            thread[i] = new Thread(()->{
                CAS1.increase1();
            });
            thread[i].start();
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(m);
        System.out.println("atomic: "+atomicI);
    }
}
