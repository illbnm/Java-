package src.com.leetcode;

import java.util.Scanner;

public class Fibonacci {
    public static int Fibonacci(int n) {

        int first = 0;
        int second = 1;
        int cur = 0;
        int i = 2;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        while (i <= n) {
            cur = first + second;
            first = second;
            second = cur;
            if (i == n)
                return cur;

            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int num = Fibonacci(5);
        System.out.println(num);
    }
}
