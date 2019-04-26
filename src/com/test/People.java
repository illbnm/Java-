package com.test;

class robot extends People {
    String name = "瓦力";
    int age = 50;

    @Override
    public void eat() {
        System.out.println("瓦力不需要吃饭");
    }

    @Override
    public void drink() {
        System.out.println("瓦力不需要喝水");
    }

    public void sing() {
        System.out.println("瓦力会唱歌");
    }

    public void play() {
        System.out.println("静态:瓦力不需要玩");
    }
}

public class People {
    String name = "人";
    int age = 20;

    public void eat() {
        System.out.println("人要吃饭");
    }

    public void Eat() {
        System.out.println("静态:人要吃饭");
    }

    public void drink() {
        System.out.println("人要喝水");

    }


    public static void main(String[] args) {
        People P = new robot();
        P.eat();
        P.drink();
        ((robot) P).play();  //不能直接访问子类的普通成员方法,只能向下造型后才能访问
        P.Eat();  //不能覆盖静态成员方法,所以访问的是父类的静态成员方法
        System.out.println(P.age + P.name);  //访问成员变量访问的是父类的成员变量

    }
}