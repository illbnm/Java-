package src.引用;

import java.lang.ref.SoftReference;

public class soft {
    public static void main(String[] args) {
        //强引用
        MyArray myArray = new MyArray();
        //软引用 作用之  缓存
        SoftReference<MyArray> softReference = new SoftReference(new MyArray());
        System.out.println(softReference.get()); //内存不够时回收
        byte[] arr = new byte[1024*1024*3];
        System.gc();
        System.out.println( softReference.get());


    }
}

class MyArray {
    byte[] arr = new byte[1024 * 1024 * 3];
}