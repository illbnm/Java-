package com.company;

public class t {
    public static void main(String[] args) {
        String a = "hello";
        a.intern();
        System.out.println(a.intern());

    }
}
