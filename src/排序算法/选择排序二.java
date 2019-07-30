package src.排序算法;

import java.util.Arrays;

public class 选择排序二 {
    public static <T extends Comparable<T>> void selectSort(T[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;
            for (int i = left; i <= right; i++) {
                if (arr[minIndex].compareTo(arr[i]) > 0) {
                    minIndex = i;
                }
                if (arr[maxIndex].compareTo(arr[i]) < 0) {
                    maxIndex = i;
                }
            }
            if (left != minIndex) {
                swap(arr, left, minIndex);
                left++;
            }
            swap(arr, right, maxIndex);
            right--;
        }
    }

    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        Integer arr[] = {0, 3, 1, 6, 0, 8, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
