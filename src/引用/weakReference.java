package src.引用;

import java.lang.ref.WeakReference;

public class weakReference {
    public static void main(String[] args) {
        //弱引用 weak Reference 使用场景 :     网页缓存
        WeakReference weakReference = new WeakReference(new people());
        System.out.println(weakReference.get());
        System.gc();//只是给了一个信号,具体回收时机还是由JVM决定
        System.out.println(weakReference.get());
    }


}

class people {
    String name;
}