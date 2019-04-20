package com.MAZE;

import java.util.Stack;

public class maze {
    static int pathSign = 0;

    public static int getPathSign() {
        return pathSign;
    }

    point[][] P = new point[6][6];
    Stack<point> MY = new Stack<>();
    point p1;  //开始由P1(1,1)开始

    public void pointInit(int x, int y, int M[][]) {  //x =6 , y =6 c初始化点坐标
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                P[i][j] = new point(i, j, M);
                System.out.println(P[i][j]);
            }
        }

    }

    public void pointInitP1(int x, int y, int M[][]) {
        p1 = new point(1, 1, M);
    }

    public point execute(point P[][], int x, int y) {
        P[x][y].setPath(pathSign++);
        if (P[x][y].getUp() == 0) {

            return P[x - 1][y];
        } else if (P[x][y].getDown() == 0)
            return P[x + 1][y];
        else if (P[x][y].getLeft() == 0)
            return P[x][y - 1];
        else if (P[x][y].getRight() == 0)
            return P[x][y+1];
        return P[x][y];
    } // 按照上下左右的顺序向前走,返回值为下一个可走的点

    public void dispose() {
        MY.empty();
        int i = 1, j = 1;
        if(this.execute(P,i,j).equals(p1)){

        }


    }

}
