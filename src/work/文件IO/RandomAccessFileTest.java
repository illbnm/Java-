package src.work.文件IO;

import java.io.*;
import java.util.Arrays;

public class RandomAccessFileTest { // 可以对文件进行随机访问
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccess = new RandomAccessFile("D:/students.txt", "rwd");
//               byte b = -1;
//                while((b=randomAccess.readByte()) != -1){
//                    System.out.println(b);
//                }
//            byte []btr = new byte[1024] ;
//            randomAccess.read(btr,0,(int)randomAccess.length());
//            System.out.println(Arrays.toString(btr));
//            long local =0 ;
//          local =   randomAccess.getFilePointer();
//            System.out.println(local);
            // 在某个位置插入一段文字
            //
            FileOutputStream    writer = new FileOutputStream("D:/student.txt");
            FileInputStream reader = new FileInputStream("D:/student.txt");

            randomAccess.seek(10);
            byte []w = new byte[1024] ;
            int len = -1;
            while ((len = randomAccess.read(w)) != -1) {
            writer.write(w,0,len);
            }

            randomAccess.seek(10);
            String str = "要插入的信息";
            byte []bytes = str.getBytes();

           // randomAccess.write(bytes);// 这里写入任何东西都会被转换为 ISO-8859-1 编码 ,因而需要使用byte进行 写入
            randomAccess.write(str.getBytes());

            System.out.println("插入成功");
            randomAccess.seek(randomAccess.getFilePointer());
            int r = 0;
            while ((r = reader.read()) != -1) {
                randomAccess.write(r);

            }
//            RandomAccessFile ran2 = new RandomAccessFile("D:/student.txt","rwd");
//            byte []re = new byte[1024];
//            while()




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
