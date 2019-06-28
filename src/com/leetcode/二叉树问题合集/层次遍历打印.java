package src.com.leetcode.二叉树问题合集;

import java.*;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class 层次遍历打印 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedBlockingQueue<TreeNode> Q = new LinkedBlockingQueue<>();
      ArrayList<Integer> arrayList = new ArrayList<>();

      arrayList.add(root.val);     //先将根节点的值放入ArrayList中
        TreeNode temp ;









        return arrayList;
    }
}
