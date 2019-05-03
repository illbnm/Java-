package src.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Classreflection {
    People P = new People("zhangsan", 19);
    String name;

    private Classreflection() {
    }

    public Classreflection(String main) {
        System.out.println("调用带参数的构造器,并生成新的对象");
    }

    public void showWithnum(String num) {
        System.out.println("获取带参数的方法");
    }

    public void showPublic() {
        System.out.println("public方法");
        System.out.println(P.getName() + "---" + P.getAge());
    }

    private void showPrivate() {
        System.out.println("private方法");
    }


    public static void main(String[] args) {

        try {
            String classname = "src.test.Classreflection";
            Class C = Class.forName(classname);
            Object O = C.newInstance();  //返回这个对象的新实例
            System.out.println(O);
            Constructor[] constructor = C.getConstructors(); //获取类的构造器 调用类的无参构造方法
            System.out.println(constructor);
//生成带参数的对象(通过带参数的构造器)
            Class class2 = Class.forName(classname);
            Constructor constructor1 = class2.getConstructor(String.class); //获取带参数的构造器
            Object o2 = constructor1.newInstance("string ");


//获取类名
            String name = C.getName();
            System.out.println(name);
//获取带参数的方法并执行
            Class class3 = Class.forName(classname);
            Method method = class3.getMethod("showWithnum", String.class); //获取带参数的方法
           // method.invoke("abc");
//调用私有方法的对象
            Method method1 = class3.getDeclaredMethod("showPrivate");
           System.out.println(method1);

        } catch (Exception e) {
                e.printStackTrace();
        }

    }
}
