package com.MAZE;

import java.util.Stack;

public class maze {
    point[][] P = new point[6][6];
    Stack<point> MY = new Stack<>();
    point p1 ;  //开始由P1(1,1)开始
    public void pointInit(int x, int y, int M[][]) {  //x =6 , y =6 c初始化点坐标
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                P[i][j] = new point(i, j, M);
                System.out.println(P[i][j]);
            }
        }

    }
    public void pointInitP1(int x,int y ,int M[][]){
        p1 = new point(1,1,M);
    }
    public  void dispose(){
        MY.empty();
        int i=1 ,j = 1 ;
        if(P[i][j].getUp() == 0  ){
            MY.push(P[i-1][j]);
        }


    }

}
