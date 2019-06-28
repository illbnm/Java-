package src.com.leetcode.二叉树问题合集;

public class 二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return left > right ? left : right;
    }
}
