package src.排序算法;

public class 选择排序二 {
    public static void seleteSort(int[] arr){
        int left= 0,right = arr.length-1;
        while (left < right){
            int minIndex = left,maxIndex = right;
            for(int i=left;i<=right;i++){
                if(arr[minIndex] > arr[i]){
                    minIndex = i;
                }
                if(arr[maxIndex] < arr[i]){
                    maxIndex = i;
                }
            }
            swap(arr,left,minIndex);
            if(left != maxIndex) {
                swap(arr, right, maxIndex);
            }
            left++;
            right--;
        }
    }
    private  static void swap(int[] arr, int m, int low) {
        int temp = arr[m];
        arr[m] = arr[low];
        arr[low] = temp;
        System.out.println("交换");
    }

    public static void main(String[] args) {

    }
}
