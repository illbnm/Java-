package src.排序算法;

import java.util.Arrays;

/**
 * Arrays.sort()
 * Coolections.sort()
 * 插入排序的时间复杂度 :O(n^2)
 * 空间复杂度
 * 稳定性 稳定
 * 越有序越快 O(n)
 **/
public class 插入排序 {

    public static <T extends Comparable<T>> void insertSort(T arr[]) {
        int j = 0;
        for (int i = 1; i < arr.length - 1; i++) { // 从第二位开始
            T temp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(temp) > 0) {
                    arr[j + 1] = arr[j];  //向后移动
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {8, 2, 5, 1, 5, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
