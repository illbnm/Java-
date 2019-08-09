package src.多线程;

import javax.management.monitor.Monitor;

public class MonitorTest {
    private static int a = 0;

    public synchronized static int getA() {
        return a;
    }

    public static void main(String[] args) {
        MonitorTest test = new MonitorTest() ;

    }
}
