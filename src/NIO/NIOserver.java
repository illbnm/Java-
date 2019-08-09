package src.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOserver {
    private int port = 8080;
    private InetSocketAddress address = null;

    private Selector selector;

    public NIOserver(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(this.port);
            // 要想富先修路
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(address);
            //默认为阻塞,手动设置为非阻塞
            server.configureBlocking(false);
            //大管家开始工作
            selector = Selector.open();
            // Option 的简称
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器准备就绪,监听端口为" + port);


        } catch (Exception e) {

        }
    }

    public void listen() {
        try {
            //轮询
            while (true) {
                // 有多少人在排队
                int wait = this.selector.select();
                if (wait == 0) {
                    continue;
                }
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    process(key);
                    iterator.remove();

                }

            }

        } catch (Exception e) {
        }
    }

    private void process(SelectionKey key) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (key.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                System.out.println(content);
                client.register(selector, SelectionKey.OP_WRITE);
                buffer.clear();
            }

        } else if (key.isWritable()) {
            SocketChannel client = (SocketChannel) key.channel();
            buffer = ByteBuffer.wrap("Hello World".getBytes());
            client.write(buffer);
        }
    }

    public static void main(String[] args) {
        new NIOserver(8080);
    }

}
