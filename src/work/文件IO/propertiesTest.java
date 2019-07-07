package src.work.文件IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesTest {
    public static void main(String[] args) {
        Properties pro = new Properties();
        //能够处理key -value 为文件结构的类
        try {
            pro.load(new FileInputStream("test.properties"));
            System.out.println(pro.getProperty("jdbcDriver"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
