package src.鲁班多线程;

public class InCreaseDemo {
    static  volatile  int m = 0 ;
    public   static  void increase(){
        m++ ; // m++ 不具有原子性
        System.out.println(m);
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <5 ; j++) {
                    increase();
                }
            }).start();
        } //

    }
}
