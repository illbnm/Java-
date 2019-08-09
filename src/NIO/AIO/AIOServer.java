package src.NIO.AIO;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {
    private int port = 8080;

    public AIOServer(int port) {
        this.port = port;
    }

    public void listen() {
    try {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
        server.bind(new InetSocketAddress(this.port));
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });


    }catch (Exception e){

    }


    }


}
