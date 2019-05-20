package src.Generic;


import java.util.Arrays;

public class test<T> implements Comparable<T> {
    private T number;

    public T getNumber() {
        return number;
    }

    //static T num;
    public test(T number) {
        this.number = number;
    }

    public T getNum() {
        return this.number;
    }

    @Override
    public int compareTo(T o) {

        return 0;
    }

    public void showType() {
        System.out.println(number.getClass().getName());
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        if (array[i].compareTo(array[j]) > 0) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
//        test t = new test((int) 9);
//        t.showType();
        Integer[] array = {1, 2};
        swap(array, 0, 1);
        System.out.println(Arrays.toString(array));
    }


}
