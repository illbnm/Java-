package src.com.leetcode;

import java.util.Arrays;

public class 使奇数位于偶数前面未完成 {

    public static void reOrderArray(int[] array) {
            for(int i = 0 ;i < array.length;i++){
                for(int j = i+1 ;j<array.length;j++){

                    if(array[i] %2 ==0 && array[j]%2==1){
                        int temp =array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 4, 5, 6, 99};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
