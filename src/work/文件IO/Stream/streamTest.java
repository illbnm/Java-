package src.work.文件IO.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class streamTest {

    public static void main(String[] args) {
        File strudent = new File("D://student.txt");
        FileInputStream in = null;
        try {
            in = new FileInputStream("D://student.txt");
            byte[] bytes = new byte[200];
            in.read(bytes);
            int c ;
            while((in.read(bytes)) != -1 ){   // 判断是否读到了末尾
                System.out.print(new String(bytes,"gbk"));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

        }
    }


}
