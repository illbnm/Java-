package src.com.leetcode;

public class 寻找重复的数 {
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= numbers.length || numbers[i] < 0) {
                duplication[0] = -1;
                return false;
            }
            if (numbers[i] != i && numbers[numbers[i]] == numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            } else if (numbers[i] != i && numbers[numbers[i]] != numbers[i]) {
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
            }
        }
        duplication[0] = -1;
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 1, 4};
        int[] dup = new int[2];
        boolean status = duplicate(numbers, numbers.length, dup);
        System.out.println(dup[0]);
        System.out.println(status);


    }
}
