package com.My;

import java.util.ArrayList;

public class Arrays {
    int[] element;
    final int INIT;
    int size;
    Object[] B = new Object[100];


    public Arrays() {
        INIT = 10;
        element = new int[INIT];
        size = 0;
    }

    public void add(int value) {
        if (size < INIT) {   //优化源码
            element[size] = value;
            size++;
        } else {
            element = java.util.Arrays.copyOf(element, element.length * 2);
        }
    }

    public void delateValue(int value) {
        int i = 0;
        while (i < element.length) {    //查找值可以分离出来
            if (element[i] == value) {
                for (int j = i; i < size; i++) {
                    element[i] = element[i + 1];
                }
                return;

            }
            i++;
        }
    }

    public boolean delateRange(int beginIndex, int endIndex) {
        if (endIndex > size) {
            return false;
        }
        int length = endIndex - beginIndex;
        for (int i = endIndex; i <= size; i++) {
            element[beginIndex++] = element[endIndex + 1];
        }
        return true;
    }

    public void delateIndex(int index) {
        for (int i = index; i < size; i++) {
            element[index + 1] = element[index];
        }
    }

    public void changeValue(int srcValue, int aimValue) {
        for (int i = 0; i <= size; i++) {
            if (element[i] == srcValue) {
                element[i] = aimValue;
            }
        }

    }

    public static void main(String[] args) {
        Arrays MyArrays = new Arrays();
        ArrayList E = new ArrayList();
        MyArrays.add(1);
        MyArrays.add(2);
        MyArrays.delateValue(2);
        MyArrays.delateRange(0, 1);
        MyArrays.changeValue(1, 2);
    }
}
