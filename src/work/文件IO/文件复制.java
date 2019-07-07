package src.work.文件IO;

import java.io.*;

public class 文件复制 {
    public static void main(String[] args) {
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("D:/students.txt"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("D:/student.txt"));
            int a = input.available();
            System.out.println(a);
            byte[] copy = new byte[1024 * 8];
            int len = -1;
            while ((len = input.read(copy)) != -1) {
                output.write(copy, 0, len);
            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
