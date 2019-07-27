package src.排序算法;

import java.util.Arrays;

/**
 *      Arrays.sort()
 *      Coolections.sort()
 *    插入排序的时间复杂度 :O(n^2)
 *    空间复杂度
 *    稳定性 稳定
 *    越有序越快 O(n)
 **/
public class 插入排序 {

    public static void insertSort(int arr[], int i, int length) {

        for (int j = 0; j < length; j++) {
            int flag = 0;
            for (int k = 1; k >= 0; k--) {
                int temp = arr[j];
                if (arr[j] < arr[k]) {
                    flag = k;
                }else
                {
                    break;
                }
            }
            for (int m =j; m >= flag; m--) {
                arr[j + 1] = arr[j];
            }
            arr[flag - 1] = arr[j];
        }
    }

    public static void main(String[] args) {
        int []arr = {8,2,5,1,5,9};
        insertSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
