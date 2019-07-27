package src.高级数据结构;

import java.util.Arrays;

public class 子集树 {
    /**
     * 有2n个整数，让你选择其中的n个数字，让选择的数字和剩下的数字它们的和的
     * 差最小，把选择的数字打印出来
     * <p>
     * <p>
     * 挑选数组中的数字== 给定的值
     * <p>
     * <p>
     * 对于子集树可以添加适当的剪枝操作
     *
     * @param args
     */
    static int[] arr = {12, 5, 7, 32, 21, 20, 18, 16};
    static int[] x = new int[arr.length];
    static int[] bestx = new int[arr.length];
    static int minval = Integer.MAX_VALUE;
    static int left = 0;
    static int choice = 0;

    public static void main(String[] args) {
        for (int val : arr) {
            left += val;
        }
        func(arr, 0, arr.length);

        System.out.println("minval:" + minval);
        System.out.println(Arrays.toString(bestx));
        /*for (int i = 0; i < bestx.length; i++) {
            if(bestx[i] == 1){
                System.out.print(arr[i] + " ");
            }
        }*/
    }

    private static void func(int[] arr, int i, int length) {
        if (i == length && choice == (arr.length) / 2) {
            int s = 0;
            for (int j = 0; j < arr.length; j++) {
                if (x[j] == 1) {
                    s += arr[j];
                }
            }
            int r = Math.abs(s - left);
            if (r < minval) {
                minval = r;
                for (int j = 0; j < x.length; j++) {
                    bestx[j] = x[j];
                }
            }


        } else {
            if (choice < (arr.length) / 2) {
                choice += 1;
                left -= arr[i];
                x[i] = 1;
                func(arr, i + 1, length);
                choice -= 1;
                left += arr[i];
            }
            x[i] = 0;
            func(arr, i + 1, length);
        }
    }


}
