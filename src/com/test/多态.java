package com.test;

public class 多态 {
    class People{
        String name = "人";
        int age = 20  ;
        public  void eat(){
            System.out.println("人要吃饭");
        }
        public void drink(){
            System.out.println("人要喝水");

        }    }
        class  robot extends People{
        String name ="瓦力";
        int age = 50 ;

            @Override
            public void eat() {
               System.out.println("瓦力不需要吃饭");
            }

            @Override
            public void drink() {
                System.out.println("瓦力不需要喝水");
            }
        }
    public static void main(String[] args) {
        多态 A = new 多态();

    }
}
