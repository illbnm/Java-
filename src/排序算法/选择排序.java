package src.排序算法;

import java.util.Arrays;

/**
 * 选择排序 :: 在待排序序列中找到最小值 ,和已排序序列交换
 * 时间复杂度:  O(n^2)
 * 空间复杂度: O(1)
 */
public class 选择排序 {
    public static <T extends Comparable<T>> void selectSort(T []arr){
        for (int i = 0; i <arr.length-1 ; i++) {
               int minIndex = i ;
            for (int j = i+1; j <arr.length-1 ; j++) {
                if(arr[minIndex].compareTo(arr[j]) > 0 ){
                    minIndex = j ;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    private static <T> void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        Integer arr[] = {2, 3, 1, 6, 0, 8, 9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
