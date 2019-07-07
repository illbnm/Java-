package src.引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;

public class pantomReference {
    //虚引用   强引用配合使用
    public static void main(String[] args) {
        people a = new people();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(a, queue);
        System.out.println(phantomReference.isEnqueued());
        System.gc();
        try {

            Thread.sleep(1000);
        } catch (Exception e) {


        }

        System.out.println(phantomReference.isEnqueued());
    }
}
