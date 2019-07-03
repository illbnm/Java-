package src.work.文件IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 字符流 {

    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("D://student.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "hello,我的世界";
        try {

            writer.write(str);

            writer.flush(); //在缓冲区完成字节和字符转换

            FileReader reader = new FileReader("D://student.txt");
            int c = -1;
            while ((c = reader.read()) != -1) {
                System.out.println(c);
                reader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
