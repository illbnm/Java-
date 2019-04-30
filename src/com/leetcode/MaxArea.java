package src.com.leetcode;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r - l);
            if (temp > maxarea)
                maxarea = temp;

            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
