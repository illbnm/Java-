package com.MAZE;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Mystack {
    private int[] element;
    private int top;

    public Mystack() {
        element = new int[10];
        top = 0;
    }

    public boolean isFull() {

        return top == element.length;
    }

    public void push(int value) {
        if (isFull()) {
            Arrays.copyOf(element, element.length * 2);
        }
        element[top++] = value;
    }

    public void pop() {  //出栈操作
        top--;
        }
    public int peek(){//出栈操作
        if(top == 0 )
            throw new EmptyStackException();
        return element[top-1];
    }

}