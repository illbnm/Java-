package src.排序算法;

import java.util.Arrays;

/**
 * 时间复杂度 :O(n^2)  最优时间复杂度O(n)
 * 空间复杂度 : O(1)
 * 稳定性 : 稳定
 */
public class 冒泡排序 {
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
      Integer []arr = {2,67,34,23,4,33,12};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
