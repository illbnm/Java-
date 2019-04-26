package com.test;

public class test2 {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        People man = new People();
        Class C = man.getClass();
        man.getClass();
     System.out.println(C);
        String classname = "java.untl.Date";


    }
}
