package src.单例模式;

import java.util.concurrent.TimeUnit;

public class Demo {
    public  static class Demo1{
        private  static  Demo  demo = new Demo();



    }
    public static void main(String[] args) {
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
