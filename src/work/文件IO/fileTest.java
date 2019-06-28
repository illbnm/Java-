package src.work.文件IO;

import java.io.File;
import java.io.IOException;

public class fileTest {
    public static void main(String[] args) {
        boolean result = false;
        File file = new File("D://fileTest/你好");
        File file1 = new File("D:/fileTest/", "a.txt");
        File file2 = new File("D:/fileTest");
        File file3 = new File(file2, "b.txt");
//        try {
//          result = file.createNewFile();
//          file1.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);

        //创建目录
        File f = new File("D:/我的目录1/我的");
        f.mkdir(); //创建时父目录必须存在
        f.mkdirs();   // mkdirs 如果父级目录不存在,先创建父级目录,在创建此目录

        f.delete();//调用即删除
        f.deleteOnExit();//程序结束前删除

    }
}
