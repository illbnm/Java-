package src.com.栈;
/**
 * 现将数据添加到第一个栈中.
 * 再将所有的数据弹出到第二个栈中
 */

import java.util.Stack;

public class 用两个栈模拟队列<E> {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {

            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty() == true) {
                while (stack1.isEmpty() != true) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }


            return 0;
        }
    }
}