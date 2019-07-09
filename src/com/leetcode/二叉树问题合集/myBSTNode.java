package src.com.leetcode.二叉树问题合集;

public class myBSTNode<T extends Comparable<T>> {
    public myBSTNode() {
        this.root = null;
    }

    private BSTNode<T> root;

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }


    /**
     * BST非递归插入
     * 1. 首先通过不断比较,找到cur == null 情况下的cur的父节点(parent)
     * 2. 再经过和其父亲节点的data比较然后再将其插入到孩子域中
     *
     * @param data
     */
    public void non_insert(T data) {
        if (this.root == null) {
            root = new BSTNode<>(data, null, null);    // #1 :当前root为null ,添加root节点
        }
        BSTNode<T> parent = null;
        BSTNode<T> cur = root;
        while (cur != null) {    // 主要目的为了找到父节点
            parent = cur;     // 每次向子节点遍历之前保存其父节点
            if (cur.getData().compareTo(data) > 0) {   //当前节点的值大于data,遍历其的左孩子
                cur = cur.getLeft();
            } else if (cur.getData().compareTo(data) < 0) { // 当前节点小于data ,遍历其的右孩子
                cur = cur.getRight();
            } else {
                return; // 相等情况直接返回
            }
        }

        if (parent.getData().compareTo(data) > 0) {
            parent.setLeft(new BSTNode<>(data, null, null));
        } else if (parent.getData().compareTo(data) < 0) {
            parent.setRight(new BSTNode<>(data, null, null));
        }

    }

    /**
     * BST递归插入
     */
    public void insert(T data) {
        this.root = insert(this.root, data);
    }

    private BSTNode<T> insert(BSTNode<T> root, T data) {
        if (root == null) {   // 如果找到为null的叶子节点,则返回要插入的新节点
            return new BSTNode<>(data, null, null);    //
        }
        //根据data的大小一直往叶子节点查找
        if (root.getData().compareTo(data) < 0) {
            root.setRight(insert(root.getRight(), data));
        } else if (root.getData().compareTo(data) > 0) {
            root.setLeft(insert(root.getLeft(), data));
        }
        return root; // 给非叶子节点返回其原来的节点,不做改变
    }


    /**
     * BST 的非递归删除
     *
     * @param data
     */
    public void non_remove(T data) {
        if (root == null) {
            return;
        }
        BSTNode<T> parent = null;
        BSTNode<T> cur = root;
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


        //相等情况直接退出 ,再做处理
        // #1: BST中不存在值为data的节点
        if (cur == null) {
            return;
        }
        //#2: 处理有两个孩子待删除节点的情况
        if (cur.getLeft() != null && cur.getRight() != null) {
            BSTNode<T> old = cur; //保存要删除的节点
            parent = cur;
            cur = cur.getLeft();   // 此处是找到要删除节点的左节点

            while (cur.getRight() != null) { // 此处判断左节点是否含有右孩子
                parent = cur;
                cur = cur.getRight();
            }
            old.setData(cur.getData());  //直接覆盖即可 ,此时就转换为删除一个节点的情况
        }

        // #3: 处理只有一个孩子节点的情况
        BSTNode<T> child = cur.getLeft();   //获取到要删除节点的孩子节点
        if (child == null) {
            child = cur.getRight();
        }

        //真正的删除操作
        if (parent == null) {   //此时表示删除的是root节点,直接将root指向 child
            this.root = child;
        } else {

            if (cur == parent.getLeft()) {     // 找到cur是父节点的哪个孩子,直接替换就行   直接将整个节点的数据都覆盖了
                parent.setLeft(child);
            } else {
                parent.setRight(child);

            }
        }
    }

    /**
     * BST的递归删除
     *
     * @param data
     */

    public void remove(T data) {
        this.root = remove(root, data);
    }

    private BSTNode<T> remove(BSTNode<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (root.getData().compareTo(data) > 0) {                //和递归插入类似
            root.setLeft(remove(root.getLeft(), data));       // 此处是直接将节点覆盖
        } else if (root.getData().compareTo(data) < 0) {
            root.setRight(remove(root.getRight(), data));
        } else {

            // #1 : 待删除节点有两个孩子的情况
            if (root.getRight() != null && root.getLeft() != null) {
                BSTNode<T> pre = root.getLeft(); // 此处找到待删节点的左孩子
                while (pre.getRight() != null) {
                    pre = pre.getRight();
                }
                root.setData(pre.getData());  // 此处的删除操作还未完成,所以是值传递
                //继续向下递归删除

                root.setLeft(remove(root.getLeft(), data));   //此处继续向左递归删除是因为 ; 取的是要删除节点左孩子的后继结点
            } else {             // 此处应该是处理只有一个节点的情况,直接将叶子节点赋值给父节点
                if (root.getLeft() != null) {
                    return root.getLeft();
                } else if (root.getRight() != null) {
                    return root.getRight();
                } else {
                    return null;
                }
            }
        }
        return root;    //此处返回的是其遍历到非叶子节点的情况
    }

    /**
     * 非递归查询操作
     *
     * @param data
     */
    public boolean non_quary(T data) {
        BSTNode<T> cur = root;
        while (cur != null) {
            if (cur.getData().compareTo(data) > 0) {
                cur = cur.getLeft();
            } else if (cur.getData().compareTo(data) < 0) {
                cur = cur.getRight();
            } else {
                return true;    // 相等情况返回true
            }
        }
        return false; // root = null 的情况和没找到的情况
    }

    /**
     * BST递归查询操作
     *
     * @param data
     */
    public boolean quary(T data) {

        return quary(root, data);
    }

    private boolean quary(BSTNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (root.getData().compareTo(data) > 0) {
            return quary(root.getLeft(), data);   // 继续向下递归查找
        } else if (root.getData().compareTo(data) < 0) {
            return quary(root.getLeft(), data);
        } else {
            return true;
        }
    }

    /**
     * 求BST树的镜像(也就是遍历问题,将整棵树遍历一遍)  此处遍历只能是先序遍历 或者 后序遍历
     * 简单来说就是将左右子树交换
     * 此时中序遍历结果为递减的
     *
     * @param
     */
    public void mirror() {

        mirror(root);
    }

    private void mirror(BSTNode<T> root) {
        if (root == null) {
            return;
        }
        BSTNode<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        mirror(root.getLeft());
        mirror(root.getRight());
    }

    /**
     * 将BST树中满足[begin,end]的数打印出来
     */

    public void findAreaDatas(T begin, T end) {

        findAreaDatas(root, begin, end);
    }

    private void findAreaDatas(BSTNode<T> root, T begin, T end) {
        if (root == null) {
            return;
        }
        if (root.getData().compareTo(begin) > 0) { //当前节点的值大于begin时,在节点的左边进行寻找
            findAreaDatas(root.getLeft(), begin, end);
        }
        if (root.getData().compareTo(begin) >= 0 && root.getData().compareTo(end) <= 0) {
            System.out.print(root.getData() + " ");
        }
        if (root.getData().compareTo(end) < 0) {//当前节点的值小于end时,在当前节点的右边进行寻找
            findAreaDatas(root.getRight(), begin, end);
        }

    }

    /**
     * 判断一个二叉树是否为BST树,是BST树返回true 不是返回false
     * 1. 由于搜索二叉树的性质 中序遍历 为递增数列
     * 2 .因而可通过判断其中序遍历前一个data的值是否小于当前data的值
     *
     * @param
     */
    BSTNode<T> pre = null; // 保存遍历前一个节点的值

    public boolean isBSTree() {

        return isBSTree(this.root);
    }

    private boolean isBSTree(BSTNode<T> root) {
        if (root == null) {
            return true;
        }
        if (!isBSTree(root.getLeft())) {   // 判断左子树返回false的情况
            return false;
        }
        if (pre != null && root.getData().compareTo(pre.getData()) < 0) {
            return false;
        }
        return isBSTree(root.getLeft());
    }

    /**
     * 求data1和data2的最近公共祖先节点 ,并返回它的值
     * 1. 由于其最近公共祖先节点一定介于 data1 与 data 2 之间
     * 2. 可以不断对当前节点的data与之比较,从而降低规模
     */
    public T getLCA(T data1, T data2) {
        if (root == null) {
            return null;
        }
        if (!non_quary(data1) || !non_quary(data2)) {
            return null;
        }
        return getLCA(root, data1, data2);

    }

    private T getLCA(BSTNode<T> root, T data1, T data2) {
        if (root == null) {
            return null;
        }

        if (root.getData().compareTo(data1) > 0 && root.getData().compareTo(data2) > 0) {
            return getLCA(root.getLeft(), data1, data2);
        } else if (root.getData().compareTo(data1) < 0 && root.getData().compareTo(data2) < 0) {
            return getLCA(root.getRight(), data1, data2);
        } else {
            return root.getData();
        }

    }

    /**
     * 返回中序的倒数第k个节点
     * 1. 有两种解决方法 1.将k转换为正数的第length - k 个数字
     *
     * @param k
     */
    public T getInOrdergetKvalue(int k) {


        return getInOrdergetKvalue(root, k);
    }


    private int i = 1;  // 定义的全局变量,用于计数

    private T getInOrdergetKvalue(BSTNode<T> root, int k) {
        if (root == null) {
            return null;
        }
        T value = getInOrdergetKvalue(root.getRight(), k);
        if (value == null) {
            return null;
        }
        if (i++ == k) {
            return root.getData();
        }
        return getInOrdergetKvalue(root.getRight(), k);

    }


    public static void main(String[] args) {
        myBSTNode BST = new myBSTNode();
        int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int va : ar) {
            BST.insert(va);
        }
        BST.inOrder();
        System.out.println();
        //System.out.println();
        //BST.remove(39);
        // BST.inOrder();
        //boolean re = BST.quary(66);
        // BST.mirror();
        // BST.inOrder();
        BST.findAreaDatas(20, 99);
        System.out.println();
    }

}

