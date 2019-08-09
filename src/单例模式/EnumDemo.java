package src.单例模式;

public enum EnumDemo {
    //常量 ,在加载实例化一次,
 A,B,C,D;
    public static  void m1 (){
        System.out.println("method");
    }

    public static void main(String[] args) {
        A.m1();
        System.out.println(A.getClass().getName());
    }
}
