package src.排序算法;

import java.util.Arrays;

public class 归并排序 {
    public static void merge(int[] arr,int gap){//4
        int left1 = 0;
        int right1 = left1+gap-1;
        int left2 = right1+1;
        int right2 = (left2+gap-1) > (arr.length-1) ? (arr.length-1) : (left2+gap-1);
        int[] brr = new int[arr.length];
        int i = 0;//遍历brr
        //有两个归并段
        while (left2 < arr.length){
            while (left1<=right1 && left2 <=right2){
                if(arr[left1] < arr[left2]){
                    brr[i++] = arr[left1++];
                }else{
                    brr[i++] = arr[left2++];
                }
            }
            if(left1 > right1){
                for(int j = left2;j<=right2;j++){
                    brr[i++] = arr[j];
                }
            }
            if(left2 > right2){
                for(int j = left1;j<=right1;j++){
                    brr[i++] = arr[j];
                }
            }
            left1 = right2+1;
            right1 = left1+gap-1;
            left2 = right1+1;
            right2 = (left2+gap-1) > (arr.length-1) ? (arr.length-1) : (left2+gap-1);
        }
        //只有一个归并段
        while (left1 < arr.length && left1 <= right1){
            brr[i++] = arr[left1++];
        }
        for(int j = 0;j<brr.length;j++){
            arr[j] = brr[j];
        }
    }

    public static void mergeSort(int[] arr){
        for(int i=1;i<arr.length;i*=2){
            merge(arr,i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,8,34,2,49,23};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
