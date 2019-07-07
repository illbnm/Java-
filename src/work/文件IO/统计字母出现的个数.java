package src.work.文件IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class 统计字母出现的个数 {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> num = new HashMap();
        BufferedReader reader = null ;
        try {
             reader = new BufferedReader(new FileReader("D:/students.txt"));
            int a = -1;
            while ((a = reader.read()) != -1) {
                ;
                if (num.containsKey(a)) {
                    Integer temp = num.get(a);
                    if (temp != null) {
                        temp++;
                        num.replace(a, temp);
                    }
                } else {
                    num.put(a, 1);
                }
            }
            for (int i = 65; i < 150; i++) {
                if (i >= 'A' && i <= 'Z') {
                    char temp = (char) i;
                    if (num.get(i) != null) {
                        System.out.print(temp + " ");
                        System.out.print(num.get(i) + "  ");
                    }
                }
                if (i >= 'a' && i <= 'z') {
                    char temp = (char) i;
                    if (num.get(i) != null) {
                        System.out.print(temp + " ");
                        System.out.print(num.get(i) + "  ");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            reader.close();
        }


    }
}
