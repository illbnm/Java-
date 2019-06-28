package src.com.leetcode;

public class 大顶堆排序 {
    public static void Sort(int[] arr) {
        int length = arr.length;
        int start = (arr.length - 2) / 2;
        for (; start >= 0; start--) {
            Adjust(arr, length, start);
        }
        for(int i = arr.length-1 ;i>0 ;i--){
            Swap(arr,0,i);
            Adjust(arr,i,0);
        }


    }

    public static void Swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void Adjust(int[] arr, int length, int start) {
        int temp = arr[start];
        int i = start;
        for (int k = start * 2 + 1; k < length; k = k * 2 + 1) {
            if (k < length - 1 && arr[k] < arr[k + 1]) {
                //此时如果节点的值大于左节点的值,k++(为右节点的index值) : 找出左右节点的value值最大的节点,将其index保存在key中
                k++;
            }
            if (arr[k] > temp) {   //如果arr[start]小于子节点的值,将其更改,i保存子节点的index
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
            arr[i] = temp; //更改子节点的值
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 21, 46, 56, 32, 23, 98};
        Sort(arr);
        for (int a : arr) {
            System.out.print(a + "  ");
        }
    }
}
