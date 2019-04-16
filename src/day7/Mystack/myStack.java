package day7.Mystack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 底部到顶   0 ~ n
 */
public class myStack {
    private int[] element;
    private int top;

    public myStack() {
        element = new int[10];
    }
    public  myStack(int value){
        element = new int[value];
    }
    private boolean isFull(){
        return top == element.length;
    }
    public void push(int value) {
        if (isFull()) {
           element = Arrays.copyOf(element,element.length*2);
        }
        element[top++] = value;
    }

    public void pop() {
        int value = 0;
        if (top <= 0) {
            element[top] = 0;
        } else if (top >= 1)
           top--;

    }

    public int  peek() {
        int value = 0   ;
        if (this.element != null) {
            if (top < 0) {
              throw  new EmptyStackException();
            }
            if (top >= 1) {
                 value = element[top];
                element[top--] = 0;
            }

        }
return  value;
    }


    public static void main(String[] args) {
        myStack stack = new myStack();
        stack.push(1);

    }
}
