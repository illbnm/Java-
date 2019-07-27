package src.com.leetcode.二叉树问题合集;

public class 跳台阶 {


    public int JumpFloor(int target) {

        return jump(target, 0);
    }


    private int jump(int target, int num) {
        if (target == 1 || target == 0) {
            return num++;
        }
        num = jump(target - 1, num);
        return jump(target - 2, num);
    }


}
