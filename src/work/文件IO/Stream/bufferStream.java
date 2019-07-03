package src.work.文件IO.Stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class bufferStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream input = null;
        byte[] btr = new byte[100];
        try {
            input = new BufferedInputStream(new FileInputStream("D://student.txt")); // 可以指定缓冲区的大小
            input.read(btr);
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (byte a : btr) {
            System.out.println();
        }

    }
}
