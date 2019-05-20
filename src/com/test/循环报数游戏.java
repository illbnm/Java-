package src.com.test;

public class 循环报数游戏 {
    public static int CyclicGame(int n) {
        int[] arr = new int[n + 1];
        int i = 1;
        int j = 1;
        int start = 1;
        int flag = 0;
        while (true) {
            arr[i] = j;
            if (j == 3) {
                arr[i] = 0;
                j = 0;
            }
            if (i == n) {
                i = 1;
            }
            i++;
            j++;

            int sum = 0;
            start = 1 ;
            while (start <= n) {
                sum += arr[start];
                if (arr[start] == 0)
                    flag++;

                start++;
            }
            if (flag == n - 1 && sum == 1 || sum == 2) {
                start = 1;
                while (start <= n) {
                    if (arr[start] != 0)
                        return start;
                }

            }

        }
    }

    public static void main(String[] args) {
        int n = 10000 ;
        int s= CyclicGame(n);
        System.out.println(s);
    }
}
