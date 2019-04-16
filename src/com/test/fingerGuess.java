package com.test;



import java.util.Random;
import java.util.Scanner;

public class fingerGuess {
    Scanner scanner = new Scanner(System.in);

    static class mochine{
        int guss ;
        public String Guess(){
            Random random = new Random();
            int num = random.nextInt(2)+1;
            String S = " ";
            if(num==1){
                S = "石头";
            }
            else if(num==2){
                S = "剪刀";
            }else if(num == 3){
                S = "布";
            }

            return S;
        }
    }
    static class People{
        Scanner scanner = new Scanner(System.in);
        String guess;
        public String Guess(){
            System.out.println("请输入你的选择 ");
            guess = scanner.next();
            return guess;
        }
        public void judge(String num){
            if(guess.equals(num)) {
                System.out.println("平局");
            }
            if(num.equals("石头")&&  guess.equals("剪刀")){
                System.out.println("你输了!");
            }
            if(num.equals("石头") && guess.equals("布") ){
                System.out.println("你赢了!");
            }

            if(num.equals("剪刀") &&  guess.equals("石头")){
                System.out.println("你赢了!");
            }
            if(num.equals("剪刀") && guess.equals("布") ){
                System.out.println("你输了!");
            }
            if(num.equals("布") &&  guess.equals("石头")){
                System.out.println("你输了!");
            }
            if(num .equals("布") && guess.equals("剪刀")){
                System.out.println("你赢了!");
            }



        }
    }

    public static void main(String[] args) {

        People man = new People();
        mochine mo = new mochine();
        while(true){
            System.out.println("石头剪刀布,1.石头 2.剪刀 3.布");

            System.out.println("你出的是:"+ man.Guess());

            String a = mo.Guess();
            System.out.println("machine:"+a);
            man.judge(a);

        }

    }
}
