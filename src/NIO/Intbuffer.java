package src.NIO;

import java.nio.IntBuffer;

public class Intbuffer {
    public static void main(String[] args) {
        // 分配新的int缓冲区,参数为缓冲区容量
        //新缓冲区的当前位置为0 ,其界限(限制位置)将为其容量
        IntBuffer buffer = IntBuffer.allocate(8);
        System.out.println(buffer.limit());
        for (int i = 0; i < 8; i++) {
            buffer.put(i);
        }
        // 固定之前的值
        // 重设缓冲区将设置限制为当前位置 ,然后将当前位置设置为0
        buffer.flip();
        while (buffer.hasRemaining()) {
            int temp = buffer.get();
            System.out.print(temp + " ");
        }

        buffer = IntBuffer.allocate(10);
        for (int i = 0; i <10 ; i++) {
            buffer.put(i);
        }

        buffer.flip();
        while (buffer.hasRemaining()) {
            int temp = buffer.get();
            System.out.print(temp + " ");
        }


    }
}
