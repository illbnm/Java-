package src.com.leetcode.二叉树问题合集;


import java.util.ArrayList;
public class BiTree {
    ArrayList<TreeNode> T;
    TreeNode head;

    public BiTree() {
        T = new ArrayList<>();     //将二叉树节点用ArrayList保存起来
    }

    /**
     * 创建二叉树
     *
     * @param arrays
     */
    public TreeNode CreateBiTree(int[] arrays) {

        for (int val : arrays) {
            T.add(new TreeNode(val));             //将所有元素先保存在TreeNode中再添加进ArrayList
        }
        head = T.get(0);                         // 将第一个元素作为头结点
        for (int i = 0; i < arrays.length / 2; i++) {
            T.get(i).left = T.get(2 * i + 1);      // 给所有元素的左节点赋值
            if (2 * i + 2 < arrays.length) {       //此处防止偶数越界
                T.get(i).right = T.get(2 * i + 2);
            }
        }
        return head;
    }

    /**
     * 先序遍历
     *
     * @param head
     */
    void PreOrderTraverses(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "   ");
        PreOrderTraverses(head.left);
        PreOrderTraverses(head.right);
    }

    /**
     * 中序遍历
     *
     * @param head
     */
    void MidOrderTraverses(TreeNode head) {
        if (head == null)
            return;
        MidOrderTraverses(head.left);
        System.out.print(head.val + "   ");
        MidOrderTraverses(head.right);

    }

    /**
     * 后序遍历
     *
     * @param head
     */
    void PostOrderTraverses(TreeNode head) {
        if (head == null)
            return;
        PostOrderTraverses(head.left);
        PostOrderTraverses(head.right);
        System.out.print(head.val + "   ");
    }


    public static void main(String[] args) {
        BiTree B = new BiTree();
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode head = B.CreateBiTree(arrays);
        B.PreOrderTraverses(head);
        System.out.println();
        B.MidOrderTraverses(head);
        System.out.println();
        B.PostOrderTraverses(head);
    }


}
