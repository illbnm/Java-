package src.高级数据结构;


/**
 * 1.BST树的性质
 * 2.BST树增加，删除，查询操作
 * 3.BST数的遍历过程
 * VLR ： 前序遍历
 * LVR ： 中序遍历
 * LRV ： 后序遍历
 * <p>
 * 递归实现和非递归实现
 * preOrder
 * inOrder
 * postOrder
 * levelOrder
 * <p>
 * number 递归实现，返回BST数中所有节点的个数
 * level  递归实现，返回BST数的层数/高度
 * <p>
 * non_query 非递归实现
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST树的节点类型
 *
 * @param <T>
 */
class BSTNode<T extends Comparable<T>> {
    // 节点的数据域
    private T data;
    // 节点的左孩子域
    private BSTNode<T> left;
    // 节点的右孩子域
    private BSTNode<T> right;

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }
}

/**
 * BST树的实现
 *
 * @param <T>
 */
class BSTree<T extends Comparable<T>> {
    // 指向BST树根节点的变量
    private BSTNode<T> root;

    /**
     * BST树的初始化
     */
    public BSTree() {
        this.root = null;
    }

    /**
     * 非递归实现BST树的插入操作
     *
     * @param data
     */
    public void non_insert(T data) {
        if (root == null) {
            // 直接生成根节点
            this.root = new BSTNode<>(data, null, null);
            return;
        }

        // 搜索BST树，找到data合适的插入位置
        BSTNode<T> parent = null;
        BSTNode<T> cur = this.root;
        while (cur != null) {
            parent = cur;
            if (cur.getData().compareTo(data) < 0) {
                cur = cur.getRight();
            } else if (cur.getData().compareTo(data) > 0) {
                cur = cur.getLeft();
            } else {
                return;
            }
        }

        // 生成data节点，并把节点写入其父节点相应的地址域当中
        if (parent.getData().compareTo(data) < 0) {
            parent.setRight(new BSTNode<>(data, null, null));
        } else {
            parent.setLeft(new BSTNode<>(data, null, null));
        }
    }

    /**
     * BST树的非递归删除操作
     *
     * @param data
     */
    public void non_remove(T data) {
        //1. 先搜索值为data的待删除节点
        if (this.root == null) {
            return;
        }

        BSTNode<T> parent = null; // parent = root
        BSTNode<T> cur = this.root;
        while (cur != null) {
            if (cur.getData().compareTo(data) > 0) {
                parent = cur;
                cur = cur.getLeft();
            } else if (cur.getData().compareTo(data) < 0) {
                parent = cur;
                cur = cur.getRight();
            } else {
                break;
            }
        }

        // BST中不存在值为data的节点
        if (cur == null) {
            return;
        }

        //2.处理有两个孩子的待删除节点情况
        if (cur.getLeft() != null && cur.getRight() != null) {
            BSTNode<T> old = cur;
            parent = cur;
            cur = cur.getLeft();

            while (cur.getRight() != null) {
                parent = cur;
                cur = cur.getRight();
            }

            old.setData(cur.getData());
        }

        //3.删除有一个孩子的或者没有孩子的节点  cur
        BSTNode<T> child = cur.getLeft();
        if (child == null) {
            child = cur.getRight();
        }

        // data  parent.getData()
        if (parent == null) { // 表示删除的是根节点
            this.root = child;
        } else {
            if (cur == parent.getLeft()) { // 把cur的child写入父节点的左孩子域
                parent.setLeft(child);
            } else { // 把cur的child写入父节点的右孩子域
                parent.setRight(child);
            }
        }
    }

    /**
     * 非递归查询操作
     *
     * @param data
     * @return
     */
    public boolean non_query(T data) {
        return false;
    }

    /**
     * 非递归实现BST树的前序遍历API
     */
    public void non_preOrder() {
        BSTNode root = this.root;
        if (root == null) {
            return;
        }
        Stack<BSTNode> S = new Stack<>();
        S.push(root);
        //先将根节点放入栈中
        while (!S.isEmpty()) { // 以栈为空作为结束条件
            BSTNode TOP = S.pop();
            System.out.print(TOP.getData() + "    ");
            if (TOP.getRight() != null) {
                S.push(TOP.getRight());
            }
            if (TOP.getLeft() != null) {
                S.push(TOP.getLeft());
            }
        }
    }

    /**
     * 递归实现BST数的前序遍历API接口
     */
    public void preOrder() {
        System.out.print("递归前序遍历：");
        preOrder(this.root);
        System.out.println();
    }

    /**
     * 前序遍历递归实现
     *
     * @param root
     */
    private void preOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " "); // V
            preOrder(root.getLeft()); // L
            preOrder(root.getRight()); // R
        }
    }

    /**
     * 递归实现BST数的中序遍历API接口
     */
    public void inOrder(BSTNode<T> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData());
            inOrder(root.getRight());


        }

    }

    /**
     * 递归事项BST树的后序遍历API接口
     */
    public void postOrder(BSTNode<T> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData() + " ");
        }


    }


    /**
     * 非递归实现层次遍历
     */

    public void levelOrder() {
        BSTNode<T> root = this.root;
        if (root == null) {
            return;
        }
        Queue<BSTNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            BSTNode<T> TOP = Q.poll();
            System.out.print(TOP.getData());
            if (TOP.getLeft() != null) {
                Q.offer(TOP.getLeft());
            }
            if (TOP.getRight() != null) {
                Q.offer(TOP.getRight());
            }

        }


    }

    /**
     * 递归实现求节点数目接口
     */
    public int Coun_API() {
        return Count(root);
    }

    /**
     * 递归实现节点的数目
     */
    public int Count(BSTNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            return Count(root.getLeft()) + Count(root.getRight()) + 1;
        }

    }

    /**
     * 求层数的API
     */
    public void level_APi() {

        level(root);
    }

    private int level(BSTNode<T> root) {


        if (root == null) {
            return 0;
        } else {
            int left = level(root.getLeft());
            int right = level(root.getRight());
            return left > right ? left + 1 : right + 1;
        }
    }


    /**
     * 递归实现层次遍历
     */

    public void levelOrder_API() {
        int level = level(root);
        for (int i = 0; i < level; i++) {
            levelOrder_(root, level(root));
        }
    }

    private void levelOrder_(BSTNode<T> root, int level) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.println(root.getData() + "   ");
        }

        levelOrder_(root.getLeft(), level - 1);
        levelOrder_(root.getRight(), level - 1);


    }

    /**
     * 求二叉树的镜像,也就是将二叉树的左右孩子树进行交换
     */
    public void mirror() {
        mirrorOrder(root);


    }

    private void mirrorOrder(BSTNode<T> root) {
        if (root != null) {
            Swap(root.getLeft(), root.getRight());
            mirrorOrder(root.getLeft());
            mirrorOrder(root.getRight());
        } else {
            return;
        }
    }

    public void Swap(BSTNode a, BSTNode b) {
        BSTNode temp;
        temp = a;
        a = b;
        b = temp;
    }

    /**
     * 把BST中满足[begin,end]区间的元素打印出来
     */
    public void findAreaData(T begin, T end) {

        findArea(root, begin, end);

    }

    private void findArea(BSTNode<T> root, T begin, T end) {
        if (root == null) {
            return;
        }
        if (root.getData().compareTo(begin) > 0) {
            findArea(root.getLeft(), begin, end);
        }
        if (root.getData().compareTo(end) < 0) {
            findArea(root.getRight(), begin, end);
        }


    }

    /**
     * 判断二叉树是否为BST树,是BST返回True  不是返回false,判断它的中序遍历是否为升序排列
     */
    public void isBST() {


        isBSTree(root, null);


    }

    /**
     * 递归实现判断它的中序遍历是否为升序排列
     *
     * @param root
     * @param i
     * @return
     */
    private boolean isBSTree(BSTNode<T> root, T i) {
        if (root == null) {
            return true;
        }
        if (!isBSTree(root.getLeft(), root.getData())) {
            return false;
        }
        if (i != null && root.getData().compareTo(i) < 0) {
            return false;
        }
        i = root.getData();
        return isBSTree(root.getRight(), root.getData());
    }

    /**
     * 求data1 和data2 最近公共祖先节点  // 比较其大小
     */


    public T getLCA(T data1, T data2) {
        return getLCA_(root, data1, data2);
    }

    private T getLCA_(BSTNode<T> root, T data1, T data2) {
        if (root == null) {
            return null;
        }


        if (root.getData().compareTo(data1) > 0 && root.getData().compareTo(data2) > 0) {
            getLCA_(root.getLeft(), data1, data2);
        } else if (root.getData().compareTo(data1) < 0 && root.getData().compareTo(data2) < 0) {

            getLCA_(root.getRight(), data1, data2);
        }
        return root.getData();

    }

    /**
     * 返回中序遍历倒数第k个节点的值
     */
//    public T getOrderK(int k) {
//        int num = Count(root);
//        return getOrderK(this.root, num - k, 0);
//    }
//
//    private T getOrderK(BSTNode<T> root, int k, int i) {
//        if (root == null) {
//            return null;
//        }
//
//
//        T value = getOrderK(root.getLeft(), k, i );
//        if(value != null ){
//            return  value ;
//        }
//        if(++i ==  k) {
//            return root.getData();
//        }
//
//    }

    /**
     * 判断tree 是不是当前 BST树的子树
     */
    public boolean isChildTree(BSTNode<T> tree) {
        return isChildTree(root, tree);


    }

    private boolean isChildTree(BSTNode<T> root, BSTNode<T> tree) {
        if (root == null) {
            return true;
        }

        return false;
    }


}


public class BST {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int val : ar) {
            bst.non_insert(val);
        }
        bst.non_insert(37);
        //bst.non_remove(86);
        bst.non_preOrder();
        System.out.println();
        bst.preOrder();

        System.out.println(bst.Coun_API());


    }
}
