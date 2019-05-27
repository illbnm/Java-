package src.com.leetcode;

public class 替换空格 {
    public static int getNum(StringBuffer str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                num += 1;
            }
        }
        return num;
    }

    public static String replaceSpace(StringBuffer str) {
        int oldLength = str.length()-1;
        int newLength = str.length() + getNum(str)*2;
        str.setLength(newLength);
       newLength = newLength - 1;
        while (oldLength > -1 ) {
            if (str.charAt(oldLength) == ' ') {
                str.setCharAt(newLength--, '0');
                str.setCharAt(newLength--, '2');
                str.setCharAt(newLength--, '%');
            } else {
                str.setCharAt(newLength--, str.charAt(oldLength));
            }
            oldLength--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "i am a student!";
        StringBuffer arr = new StringBuffer("i an student!");
//        int num = getNum(arr);
//        System.out.println(num);
        String brr = replaceSpace(arr);
        System.out.println(brr);

    }
}
