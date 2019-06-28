package src.com.leetcode.二叉树问题合集;
/**
 * 1.BST树的性质
 * 2 .BST树的查询,删除
 * 3. BST树的遍历过程
 * VLR ::前序遍历
 * LVR : 中序遍历 (小到大 有序)
 * LRV : 后序遍历
 * 层次遍历
 * 递归实现和非递归实现
 * preOreder
 *
 *
 *
 * number 递归实现 返回BST 中所有节点的个数
 * level 递归实现返回层数
 * non_query  非递归实现
 */

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

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode getRight() {
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
            root = new BSTNode<>(data, null, null);
        }
        BSTNode<T> N;
        BSTNode<T> parent;
        N = root;

        while (N != null) {
//            if (N.getData().compareTo((T) data) < 0) {
//                if (N.getLeft() == null) {
//                    N.getLeft().setData(data);
//                } else {
//                    N = N.getLeft();
//                }
//
//            } else {
//                if (N.getRight() == null) {
//                    N.getRight().setData(data);
//                } else {
//                    N = N.getRight();
//                }
//            }

            parent = N;
            if (N.getData().compareTo((data)) > 0) {
                N = N.getRight();
            } else if (N.getData().compareTo((data)) < 0) {
                N = N.getLeft();
            } else {
                return;
            }
            if (parent.getData().compareTo(data) > 0) {
            }


        }
    }

    public void non_delete(T data) {
        //1. 先搜索元素
        BSTNode cur = root;
        BSTNode parent = null;
        while (cur != null) {
            parent = cur;
            if (cur.getData().compareTo(data) == 0) {
                break;
            } else if (cur.getData().compareTo(data) > 0) {
                cur = cur.getRight();
            } else if (cur.getData().compareTo(data) < 0) {
                cur = cur.getLeft();
            }
        }
        if (cur == null) {
            return;
        }

        //寻找其前驱节点和后继结点
        BSTNode pre = null;
        BSTNode aft = null;
        BSTNode T;
        T = cur.getLeft();
        while (T.getRight() != null) {
            pre = T.getRight();
        }
        T = cur.getRight();
        while (T.getLeft() != null) {
            aft = T.getLeft();
        }
        //1.删除只有一个孩子,没有孩子
        if (cur.getRight() != null && cur.getLeft() == null) {

        } else if (cur.getLeft() == null && cur.getRight() != null) {

        } else if (cur.getRight() == null && cur.getLeft() == null) {

        }


        //3. 要删除节点有两个孩子

        if (cur.getLeft() != null && cur.getRight() != null && pre != null || aft != null) {
            BSTNode S,P;    // S 前驱或者后继节点  P 要覆盖的节点
            if (pre != null) {
                S = pre;
            } else {
                S = aft;
            }




        }

    }
    /**
     * BST树的非递归删除操作
     * @param data
     */
    public void non_remove(T data){
        //1. 先搜索值为data的待删除节点
        if(this.root == null){
            return;
        }

        BSTNode<T> parent = null; // parent = root
        BSTNode<T> cur = this.root;
        while(cur != null){
            if(cur.getData().compareTo(data) > 0){
                parent = cur;
                cur = cur.getLeft();
            } else if(cur.getData().compareTo(data) < 0){
                parent = cur;
                cur = cur.getRight();
            } else {
                break;
            }
        }

        // BST中不存在值为data的节点
        if(cur == null){
            return;
        }

        //2.处理有两个孩子的待删除节点情况
        if(cur.getLeft() != null && cur.getRight() != null){
            BSTNode<T> old = cur;
            parent = cur;
            cur = cur.getLeft();

            while(cur.getRight() != null){
                parent = cur;
                cur = cur.getRight();
            }

            old.setData(cur.getData());
        }

        //3.删除有一个孩子的或者没有孩子的节点  cur
        BSTNode<T> child = cur.getLeft();
        if(child == null){
            child = cur.getRight();
        }

        // data  parent.getData()
        if(parent == null){ // 表示删除的是根节点
            this.root = child;
        } else {
            if(cur == parent.getLeft()){ // 把cur的child写入父节点的左孩子域
                parent.setLeft(child);
            } else { // 把cur的child写入父节点的右孩子域
                parent.setRight(child);
            }
        }
    }
    public void inOrder(BSTNode<T> root ){
        if(root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " " );
        inOrder(root.getRight());
    }

    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int val : ar) {
            bst.non_insert(val);
        }
        bst.non_insert(37);

    }

}
