package src.work.文件IO.序列化;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutput {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("D://1.txt"));
            People A = new People("wang", 12, 1);
            out.writeObject(A);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class People implements Serializable {
    String name;
    int age;
    int sex;

    public People(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}