package test;

import java.util.Random;
import java.util.Scanner;

public class fingerGuess {
    Scanner scanner = new Scanner(System.in);

    static class mochine{
        int guss ;
        public int Guess(){
            Random random = new Random();
            int num = random.nextInt(2)+1;
            return num ;
        }
    }
    static class People{
        Scanner scanner = new Scanner(System.in);
        int guess;
        public int Guess(){
            System.out.println("请输入你的选择 ");
            guess = scanner.nextInt();
            return guess;
        }
        public void judge(int num){
            if(num == guess) {
                System.out.println("平局");
            }
                if(num ==1 &&  guess == 2){
                    System.out.println("你赢了!");
            }
                if(num == 1 && guess == 3 ){
                    System.out.println("你输了!");
                }

                if(num ==2 &&  guess == 1){
                    System.out.println("你输了!");
                }
                if(num == 2 && guess == 3 ){
                    System.out.println("你赢了!");
                }
                if(num ==3 &&  guess == 1){
                    System.out.println("你赢了!");
                }
                if(num == 3 && guess == 2){
                    System.out.println("你输了!");
                }



        }
    }

    public static void main(String[] args) {
        System.out.println("石头剪刀布,1.石头 2.剪刀 3.布");
        People man = new People();
        mochine mo = new mochine();
       while(true){
           System.out.println("石头剪刀布,1.石头 2.剪刀 3.布");
           man.Guess();
           man.judge(mo.Guess());

       }

    }
}
