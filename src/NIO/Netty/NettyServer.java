package src.NIO.Netty;

public class NettyServer {
    private static final String IP = "127.0.0.1";
    private static final int port = 6666;
    // 核心线程数   机器cpu核心数*2
    public static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;

    //线程d大小
    public static final int BIZTHREADSIZE = 100;


}
