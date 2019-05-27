package src.com.leetcode;

public class 实现1到n的相加 {
    public static int Sum_Solution(int n) {
        int ans = n;
        boolean t = ((ans != 0) && ((ans += Sum_Solution(n - 1)) != 0));
        // boolean t = ((num != 0) && ((sum += Sum_Solution(n - 1)) != 0));
        //boolean s = ((ans != 0 )&& ((ans += Sum_Solution(n-1)) != 0));
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int sum = Sum_Solution(3);
        System.out.println(sum);
    }
}
