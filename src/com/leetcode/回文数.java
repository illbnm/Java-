package src.com.leetcode;

public class 回文数 {
    public boolean isPalindrome(String s) {
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] != arr[(s.length() - 1)]) {
                return false;
            } else {
                flag = true;
            }
        }

        return flag;
    }
}
