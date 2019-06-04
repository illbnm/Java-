package src.com.栈;

import java.util.Stack;

public class 包含min的栈 {
    public class Solution {
        Stack stack = new Stack();

        public void push(int node) {
            int min;
            if (stack.isEmpty()) {
                min = node;
                stack.push(node);
                stack.push(min);
            } else {
                min = (int) stack.pop();
                if (min >= node) {
                    min = node;
                    stack.push(node);
                    stack.push(min);
                } else {
                    stack.push(node);
                    stack.push(min);
                }

            }
        }

        public void pop() {
            int min = (int)stack.pop();
            stack.pop();
            stack.push(min);
        }

        public int top() {
            int top = 0;
            if(!stack.isEmpty()){
                return 0;
            }
            int min = (int) stack.pop();
            if (stack.peek() != null)
            {
                return  (int)stack.peek();
            }else {
                return  min;
            }
        }

        public int min() {
            return (int)stack.pop();
        }
    }
}
