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
                //System.out.println(P[i][j]);
            }
        }

    }

    public void pointInitP1(int x, int y, int M[][]) {
        p1 = new point(1, 1, M);
    }

    public point execute(int x, int y, int flag) {
        if (flag >= 4) {
            return P[x][y];
        }    //flag = 0 上
        if (P[x][y].getUp() == 0 && flag == 0) {
            return P[x - 1][y];
        } else if (P[x][y].getDown() == 0 && flag == 1)
            return P[x + 1][y];
        else if (P[x][y].getLeft() == 0 && flag == 2)
            return P[x][y - 1];
        else if (P[x][y].getRight() == 0 && flag == 3)
            return P[x][y + 1];
        return P[x][y];
    } // 按照上下左右的顺序向前走,返回值为下一个可走的点

    public int dispose(int x, int y, int endx, int endy) {
        MY.empty();
        MY.push(P[x][y]);

        point temp;
        while (MY.isEmpty() != true) {
            //  if(int i == enx && int j == endy){
                    for(int i =1 ;i<=endx;i++){
                        for(int j = 1;i<=endy;i++)
                        {
                            if(P[i][j].path != -1){
                                System.out.println(P[i][j].getPath()+"  " );
                            }
                            else
                            {
                                System.out.println("-1");
                            }

                        }                    }
            //  }


            //return 1;//找到最后一条路径返回1

//            if(execute(P[x][y].getX(),P[x][y].getY()).equals(P[x][y])) {
//                execute(P[x][y].getX(),P[x][y].getY());
//                MY.pop();
//                MY.peek().
//            }else
//            {       temp = execute(P[x][y].getX(),P[x][y].getY());
//                MY.push(temp);
//                temp.path =pathSign++;
//            }
            temp = execute(P[x][y].getX(), P[x][y].getY(), 0);
            while (temp.equals(P[x][y]) == true) {
                int flag = 1;
                temp = execute(P[x][y].getX(), P[x][y].getY(), flag++);

            }
            if (temp.equals(P[x][y])) {

                MY.pop();
                x = MY.peek().getX();
                y = MY.peek().getY();

            } else {
                MY.add(temp);
                temp.setPath(pathSign++);
                x = temp.getX();
                y = temp.getY();
            }

        }
        return 0;
    }

}
