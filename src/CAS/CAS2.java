package src.CAS;

import javax.management.monitor.Monitor;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS2 {
    public static AtomicInteger atomic = new AtomicInteger(100);
    public static AtomicStampedReference asi = new AtomicStampedReference(100,1);
    public static void main(String[] args) {

//        Thread t1 = new Thread(() -> {
//            System.out.println(atomic.compareAndSet(100, 110));
//        });
//        t1.start();
//
//        Thread t2 = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(atomic.compareAndSet(110, 100));
//        });
//        t2.start();
//
//        Thread t3 = new Thread(() -> {
//
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(atomic.compareAndSet(100, 120));
//        });
//        t3.start();
        System.out.println("===============================================================");

        Thread tf1 = new Thread(()-> {

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(asi.compareAndSet(100,110,asi.getStamp(),asi.getStamp()+1));
            System.out.println(asi.compareAndSet(110,100,asi.getStamp(),asi.getStamp()+1));
        } );







        Thread tf2 = new Thread(()-> {
            int stamp = asi.getStamp();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(asi.compareAndSet(100,120,stamp,stamp+1));

        } );
        tf1.start();
        tf2.start();



    }

}
