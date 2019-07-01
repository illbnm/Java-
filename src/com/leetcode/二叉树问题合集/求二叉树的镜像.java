package src.com.leetcode.二叉树问题合集;

public class 求二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }


    public void Swap(TreeNode a, TreeNode b) {
        TreeNode temp;
        temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {

    }
}
