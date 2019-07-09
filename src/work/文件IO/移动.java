package src.work.文件IO;

import java.io.File;
import java.io.IOException;

public class 移动 {
    public static void main(String[] args) {
        File file = new File("D:/a.txt");
        File Iotest = new File("D:/Iotest");
        try {
            file.createNewFile();
            Iotest.mkdir();
            File f = new File("D:/Iotest/a.txt");
            file.renameTo(f);
            file.deleteOnExit();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
