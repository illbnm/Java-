package src.SingleListNOHEAD;

public class 静态内部类与实例内部类 {

    static class Entry {
        int value;
    }

    静态内部类与实例内部类.Entry entry = new 静态内部类与实例内部类.Entry();

    public class Entry2 {
        int value;
    }

    静态内部类与实例内部类.Entry2 entry2 = new 静态内部类与实例内部类().new Entry2();

        int num ;
}
