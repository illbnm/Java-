package src.work.文件IO;

import java.io.*;

public class 文件复制 {
    public static void main(String[] args) {
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream("D:/students.txt"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("D:/student.txt"));
            int a = -1;
            while ((a = input.read()) != -1) {
                output.write(a);

            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
