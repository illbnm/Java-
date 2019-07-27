package src.com.leetcode.二叉树问题合集;


public class BST重建 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode rebuild(int[] pre, int i, int j, int[] in, int m, int n) {
        if (i > j || m > n) {
            return null;
        }
        TreeNode node = new TreeNode(pre[i]);
        for (int k = m; m <= n; ++k) {
            if (pre[i] == in[k]) {
                node.left = rebuild(pre, i + 1, j + (k - m), in, m, k - 1);
                node.right = rebuild(pre, i + (k - m)+1, j, in, k + 1, n);
                return node ;
            }

        }

        return node;
    }

}
