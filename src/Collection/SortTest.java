package src.Collection;

/**
 * 堆排序
 */
public class SortTest {
    public static void Sort(int[] arr) {
        int length = arr.length;
        int start = (length - 2) / 2; //从底部开始  ,求其父节点位置

        while (start >= 0 && length >= 2) {

            int temp = arr[start];
            int maxl = Math.max(arr[start], arr[start * 2 + 1]);
            int maxr = Math.max(arr[start], arr[start * 2 + 2]);
            int max = Math.max(maxl, maxr);


            if (arr[start] == max) {
            } else if (arr[start * 2 + 1] == max) {
                arr[start] = max;
                arr[start * 2 + 1] = temp;
            } else if (arr[start * 2 + 2] == max) {
                arr[start] = max;
                arr[start * 2 + 2] = temp;
            }
            length -= 2;
            start = (length - 2) / 2;

        }

    }

    public static void main(String[] args) {
        int[] arr = {45, 21, 46, 56, 32, 23, 98};
        Sort(arr);
        for (int a : arr)
            System.out.println(a);
    }
}
