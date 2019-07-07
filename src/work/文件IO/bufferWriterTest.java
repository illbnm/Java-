package src.work.文件IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bufferWriterTest {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/students.txt"));
            String str  = "youshijni1 我的好朋友";
            writer.write(str,0,str.length());
            writer.flush();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
