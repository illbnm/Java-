package src.排序算法;

import java.util.Arrays;

/**
 * 时间复杂度 :  log2(n)n
 * 最差时间复杂度 : O(n^2)  递增序列 退化成冒泡
 * 优化:对基准进行优化
 * 一 .随机选取基准
 * 二 . 三数取中
 * 三. 插入排序
 * 四. 聚集元素
 */
public class 快速排序 {
    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {//从右向左找比基准小的数,放置left下标所在位置
                right--;
            }
            //此时 arr[right] < temp
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            //此时 arr[left] > temp
            arr[right] = arr[left];
        }
        //left == right
        arr[left] = temp;
        return left;
    }

    public static int partitionPro(int[] arr, int left, int right) {

        int tempIndex = 0;

        int tempValue = arr[left];
        arr[left] = arr[tempIndex];
        arr[tempIndex] = tempValue;
            Arrays.sort(arr);
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {//从右向左找比基准小的数,放置left下标所在位置
                right--;
            }
            //此时 arr[right] < temp
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            //此时 arr[left] > temp
            arr[right] = arr[left];
        }
        //left == right
        arr[left] = temp;
        return left;
    }

    private static void quick(int[] arr, int left, int right) {
        int index = partitionPro(arr, left, right);// index 表示最终放置基准的位置
        if (index - left > 1) {//左边有值  index 左边大于== 1
            quick(arr, left, index - 1);
        }
        if (right - index > 1) {//右边有值
            quick(arr, index + 1, right);
        }
    }

    public static void quickSort(int[] arr) {

        quick(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 5, 9};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
