package src.work.文件IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class 倒序读 {
    public static void main(String[] args) {


    RandomAccessFile my = null;

    {
        try {
            my = new RandomAccessFile("D:/students.txt","rwd");

            byte []redads= new byte[1024] ;

            my.read(redads,0,(int)my.length()-1);
            System.out.println(Arrays.toString(redads));




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }
}
