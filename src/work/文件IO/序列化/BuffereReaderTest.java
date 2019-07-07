package src.work.文件IO.序列化;

import java.io.*;

public class BuffereReaderTest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/student.txt"), "gbk"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/students.txt"), "gbk"));
            String str = "";
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
