package src.work.文件IO.Stream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class bufferOutStream {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream out = null;


        try {
            out = new BufferedOutputStream(new FileOutputStream("D://students.txt",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = "wode1shijiemeiyouni";
        out.write(str.getBytes());
        out.write(str.getBytes());
        out.write(str.getBytes());
        out.write(str.getBytes());
        out.flush();

    }
}
