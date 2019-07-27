package src.高级数据结构;

import java.util.Arrays;

/**
 * 动态规划算法思想 :
 * 和分治算法思想一样,将大规模转换为小规模
 * 动态规划子问题的特点是 : 子问题划分很多是重复的(也就是很多子问题被重复求解) ,而分治算法划分的子问题是不会重叠的
 * (也就是子问题不会被重复求解)
 * 动态两个要素 :
 * 1. 子问题重叠
 * 2. 最优子结构性质
 * <p>
 * 步骤
 * 1. 找状态  dp[i]  中间的状态
 * 2 分析 '状态转义方程 ' dp[15] >> dp[14] >>
 */
public class 动态规划 {

    static int[] arr = {-2, 11, -4, 13, -5, -2};
    static int dp[] = new int[arr.length];

    public static void main() {
        dp[0] = arr[0];
        if (arr[0] < 0) {
            dp[0] = 0;
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i] + dp[i - 1];
            if (dp[i] < 0) {
                dp[i] = 0;
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}

/**
 * 最长非降子序列的长度(可以不连续)
 * dp[i] 代表到当前i位置的最长子序列长度
 * dp[0] = 1 ;
 * dp[1] = 1 + arr[1] > arr[1] && arr[0] && 1 +dp[0]
 * dp[2]=
 */
class LIS {
    static int arr[] = {8, 4, 5, 3, 7, 9};
    static int dp[] = new int[arr.length];

    public static void main(String[] args) {

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && 1 + dp[j] > dp[i]) {  // 这里是比较与当前值小的位置的值,并用其更新
                    dp[i] = 1 + dp[j];                      // 之前的小于它的arr[i]的值可能为多个,用dp值最大的更新
                    // 4 1 2 1 7 8 9
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }

}

/**
 * 三角数组求最大和问题
 * 5
 * 6    7
 * 12   4   18
 * 9   17  8   6
 * 从顶端的元素开始 向下走,求其和的最大值
 */


 class 三角数组求最大和问题 {
    public static void main(String[] args) {
        int[][] ar = {  // 47
                {5},
                {6, 7},
                {12,4, 18},
                {9, 17,8, 6}};

        int[][] dp = new int[ar.length][ar.length];
        for (int i = 0; i < ar[ar.length - 1].length; i++) {
            dp[ar.length-1][i] = ar[ar.length-1][i];
        }
        System.out.println(Arrays.deepToString(dp));

        for(int i=ar.length-2; i>=0; --i){
            for (int j = 0; j < ar[i].length; j++) {
                int n1 = dp[i+1][j];
                int n2 = dp[i+1][j+1];
                int n3 = 0;
                if(j-1 >= 0){
                    n3 = dp[i+1][j-1];
                }

                dp[i][j] = ar[i][j] + Math.max(Math.max(n1,n2), n3);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][0]);
    }
}

class Corn {
    static int[] arr = {1, 3, 5};
    static int c = 15;

    static int num = 0;

    public int getnum() {

        return func(c);

    }

    public int func(int C) {
//        if(c == 0 ){
//            return
//        }
        if (c == 1 || c == 3 || c == 5) {
            return 1;
        } else {
            if (c < 3) {

            }
        }


        return 0;
    }


//    public static void main(String[] args) {
//        /**
//         *  1 + func(c-1)
//         *  3 + func(c-3)
//         *  5 + func(c-5)
//         */
//    }
}
/**
 *  求两个字符串 最长的公共子串 ? 一定连续
 *  最长公共子序列 ? 可以不连续
 */
/**
 * 描述:
 * 求两个字符串最长的公共子串？ 一定要连续
 * 求两个序列最长的公共子序列？ 不一定连续
 * hello world
 * helxdld
 *
 * X = {X1,X2...Xn-1,Xm}
 * Y = {Y1,Y2...Yn-1,       Yn}
 *
 * 当Xm == Yn
 * LCS(X[1,m],Y[1,n]) = 1 + LCS(X[1,m-1],Y[1,n-1])
 * 当Xm != Yn
 * LCS(X[1,m],Y[1,n]) =
 *  max{LCS(X[1,m-1],Y[1,n]), LCS(X[1,m],Y[1,n-1])}
 *
 * @Author shilei
 * @Date 2019/7/18
 */
 class LCS {
    public static void main(String[] args) {
        String str1 = "helloworld";
        String str2 = "helxtld";
        // dp[i][j]:i表示str1元素的下标 j表示str2元素的下标
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int size = LCS(str1, str2, str1.length()-1, str2.length()-1, dp);
        System.out.println(size);
        System.out.println(number);
    }

    static int number = 0;
    private static int LCS(String str1, String str2
            , int m, int n, int[][] dp) {
        if(m < 0 || n < 0){
            return 0;
        }

        if(dp[m][n] > -1){
            return dp[m][n];
        }
        number++;

        if(str1.charAt(m) == str2.charAt(n)){
            dp[m][n] = 1 + LCS(str1, str2, m-1, n-1, dp);
        } else {
            int n1 = LCS(str1, str2, m-1, n, dp);
            int n2 = LCS(str1, str2, m, n-1, dp);
            if(n1 > n2){
                dp[m][n] = dp[m-1][n];
            } else {
                dp[m][n] = dp[m][n-1];
            }
        }
        return dp[m][n];
    }
}
 class LCS02 {
     /**
      * 公共子串
      */
    static String str1 = "helloworld";
    static String str2 = "helxtld";
    static int[][] dp = new int[str1.length()+1][str2.length()+1];
    public static void main(String[] args) {
        int max = 0;
        int k = 0;
        for(int m=1; m<=str1.length(); ++m){
            for(int n=1; n<=str2.length(); ++n){
                if(str1.charAt(m-1) == str2.charAt(n-1)){
                    dp[m][n] = 1 + dp[m-1][n-1];
                }
                if(max < dp[m][n]){
                    max = dp[m][n];
                    k = m;
                }
            }
        }
        System.out.println(max);
        System.out.println(str1.substring(k-max, k));
        /**
         * 公共子序列
         */

        /*for(int m=1; m<=str1.length(); ++m){
            for(int n=1; n<=str2.length(); ++n){
                if(str1.charAt(m-1) == str2.charAt(n-1)){
                    dp[m][n] = 1 + dp[m-1][n-1];
                } else {
                    if(dp[m-1][n] > dp[m][n-1]){
                        dp[m][n] = dp[m-1][n];
                    } else {
                        dp[m][n] = dp[m][n-1];
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[str1.length()][str2.length()]);*/
    }
}
/**
 *  0-1背包
 *  w1 w2 w3
 *  v1 v2 v3
 *  背包容量c,求最优价值
 *  需要求解背包容量 1 - c 所有容量价值的最优解
 *
 */




