package src.com.leetcode;

import java.sql.SQLOutput;
import java.util.Stack;

public class 栈的压入与弹出序列 {


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < popA.length) {
            if (pushA[i] == popA[j]) {
                stack.push(pushA[i]);
                stack.pop();
                j++;
            } else {
                stack.push(pushA[i]);
            }
            i++;
        }
        while (j < popA.length) {
            if (stack.pop() != popA[j]) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        boolean re = IsPopOrder(push, pop);
        System.out.println(re);
    }
}
