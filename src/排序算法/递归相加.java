package src.排序算法;

public class 递归相加 {

    public static int add(int num) {
        if (num == 0) {
            return 0;
        }
        return num + add(num - 1);
    }


    public static int fab(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fab(n - 1) + fab(n - 2);
    }

    public static int binarySearch(int[] arr, int left, int right, int num) {
        int midIndex = ((right - left) >> 1) + left;
        if (arr[midIndex] == num) {
            return midIndex;
        }

        if (arr[midIndex] < num) {
            return binarySearch(arr, left, midIndex - 1, num);
        }
        if (arr[midIndex] > num) {
            return binarySearch(arr, midIndex + 1, right, num);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(fab(3));
        int arr[] ={1,24,56,89,101};
        int num =3;
        binarySearch(arr,0,arr.length-1,num);
    }

}
