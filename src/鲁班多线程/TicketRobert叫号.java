package src.鲁班多线程;

public class TicketRobert叫号 extends Thread {
    private static int Index = 1;
    private static final int MAX = 50;

    @Override
    public void run() {
        synchronized (this) {  //封锁当前对象
            while (Index <= MAX) {
                System.out.println(Thread.currentThread().getName() + "叫到的号码" + (Index++));
            }
        }
    }

    public static void main(String[] args) {
        TicketRobert叫号 t1 = new TicketRobert叫号();
        TicketRobert叫号 t2 = new TicketRobert叫号();
        TicketRobert叫号 t3 = new TicketRobert叫号();
        TicketRobert叫号 t4 = new TicketRobert叫号();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
