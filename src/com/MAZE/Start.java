package com.MAZE;

import java.util.Scanner;

public class Start {
  maze Maze = new maze();

    public void mazeInit(int x ,int y ,int M[][]){

        Maze.pointInit(x,y,M);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int X = 5;
        final int Y = 5;

        int[][] M = {    //5*5的地图,周围用一填充
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
//        int S[][] = new int[X + 2][X + 2];
//        for (int i = 0; i < X + 2; i++) {
//            for (int j = 0; j < Y + 2; j++) {
//                if (i == 0 || j == 0 || i == 6 || j == 6) {
//                        S[i][j] = 1 ;
//                }else
//                S[i][j] = scanner.nextInt();
//
//            }
//        }
//
//        for(int []num : S){
//            for(int nums : num)
//            {
//                System.out.print(nums+" ");
//            }
//            System.out.println(" ");
//        }
        Start start = new Start();
        start.mazeInit(X,Y,M);

    }
}
