package src.鲁班多线程.VolatileDemo;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ReadAndUpdater {
    final static int MAX = 50;
    static volatile int init_value;


    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (localValue != init_value) {
                    System.out.println("The initValue is " + init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localVlaue = init_value;
            while (localVlaue < MAX) {

                System.out.println("The init_Value will be change to " + (++localVlaue));
                init_value = localVlaue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }, "Updater").start();
        ;


    }
}
