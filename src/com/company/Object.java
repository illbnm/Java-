package com.company;
import com.*;
public class Object {
    public static class airPlane {
        String name;
        int year;
        String color;

        public String getName() {
            return name;
        }

        airPlane(String na, int ye, String co) {
                name = na;
                year = ye;
                color = co;
        }
        void fly() {
            System.out.println("起飞了");

        }
        void pullOff() {
            System.out.println("降落了");
        }
    }
    public static void main(String[] args) {
        airPlane cherry = new airPlane(" ac",2019,"zc");
        cherry.fly();
        ;
        cherry.pullOff();

    }
}