package com.leetcode;

class aprint {
    public aprint() {
        System.out.println("成员变量初始化");
    }
}

class bprint {
    public bprint() {
        System.out.println("静态变量初始化");
    }

}

class People {

    private aprint a = new aprint();
    private static bprint b = new bprint();

    static {

        System.out.println("静态块");
    }
    {
        System.out.println("实例块");
    }

    public People() {

        System.out.println("构造方法");

    }

    public static void main(String[] args) {
        People man = new People();
        String a = "ss";
        a = "bb";
    }
}