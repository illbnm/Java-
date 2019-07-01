package src.com.leetcode.二叉树问题合集;

import java.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class 层次遍历打印 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> Tree = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Tree.add(root);
        while (!Tree.isEmpty()) {
            TreeNode top = Tree.get(0);
            result.add(top.val);
            Tree.remove(0);
            if (top.left != null) {
                Tree.add(top.left);
            }
            if (top.right != null) {
                Tree.add(top.right);
            }
        }
        return (ArrayList) result;
    }
}
