package src.com.leetcode;

import java.util.Arrays;

public class 使奇数位于偶数前面 {
    static public void reOrderArray(int[] array) { // 想用个快慢指针
        int start = 0;
        int second = start + 1;
        while (start < array.length) {
            if (array[start] % 2 == 0) {
                while (second < array.length) {
                    if (array[second] % 2 == 1) {
                        int temp = 0;
                        temp = array[start];
                        array[start] = array[second];
                        array[second] = temp;
                        second++;
                        break;
                    } else {
                        second++;
                    }

                }
            }
            start++;
            second = start + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
