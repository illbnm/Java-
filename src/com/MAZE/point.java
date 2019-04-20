package com.MAZE;


public class point {
    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public int getUp() {
        return up;
    }

    private int x;
    private int y;
    private int up = 0;
    private int down = 0;
    private int left = 0;           //默认上下左右都为通路  用0标记
    private int right = 0;

    public void setPath(int path) {
        this.path = path;
    }

    public int getPath() {
        return path;
    }

    int path = -1;
    public point(int x, int y, int M[][]) { //此处默认填充迷宫周围为1
        this.x = x;
        this.y = y;
        if (M[x - 1][y] == 1)
            up = 1;
        if (M[x + 1][y] == 1)
            down = 1;
        if (M[x][y - 1] == 1)
            left = 1;
        if (M[x][y + 1] == 1)
            right = 1;
    }
//public  int[][] judge(){
//        if(up == 0 )
//            return 0;
//}
    public String toString(){
        return "竖坐标:"+x+"横坐标:"+y +"上"+up+"下"+down+"左"+left+"右"+right;
    }

}
