package src.work.文件IO.Stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class outPutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("D://students.txt", true); // 第二个参数true 表示为追加写入 false 为 覆盖写入
        } catch (Exception e) {
            e.printStackTrace();
        }
//        out.write(65);   // 写入的是 ASCII转换后的值 'A'\
//        String str = "hello world";
//        byte[] btr = str.getBytes();
//        out.write(btr,5,2);
        String str = "你好,我的世界";
        byte[] btr = str.getBytes();

            out.write(btr);


    }


}
