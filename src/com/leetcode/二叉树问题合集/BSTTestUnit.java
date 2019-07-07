package src.com.leetcode.二叉树问题合集;

/**
 *
 * 1.BST树的性质
 * 2.BST树增加（insert），删除(remove)，查询操作  非递归
 * 3.BST数的遍历过程
 * VLR ： 前序遍历
 * LVR ： 中序遍历
 * LRV ： 后序遍历
 *
 * 递归实现和非递归实现
 * preOrder
 * inOrder
 * postOrder
 * levelOrder
 *
 * number 递归实现，返回BST数中所有节点的个数
 * level  递归实现，返回BST数的层数/高度
 *
 * non_query 非递归实现
 */



/**
 * BST树的节点类型
 * @param <T>
 */
class BSTNode<T extends Comparable<T>>{
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
 * @param <T>
 */
class BSTree<T extends Comparable<T>>{
    // 指向BST树根节点的变量
    BSTNode<T> root;

    /**
     * BST树的初始化
     */
    public BSTree() {
        this.root = null;
    }

    /**
     * 非递归实现BST树的插入操作
     * @param data
     */
    public void non_insert(T data){
        if(root == null){
            // 直接生成根节点
            this.root = new BSTNode<>(data, null, null);
            return;
        }

        // 搜索BST树，找到data合适的插入位置
        BSTNode<T> parent = null;
        BSTNode<T> cur = this.root;
        while(cur != null){
            parent = cur;
            if(cur.getData().compareTo(data) < 0){
                cur = cur.getRight();
            } else if(cur.getData().compareTo(data) > 0){
                cur = cur.getLeft();
            } else {
                return;
            }
        }

        // 生成data节点，并把节点写入其父节点相应的地址域当中
        if(parent.getData().compareTo(data) < 0){
            parent.setRight(new BSTNode<>(data, null, null));
        } else {
            parent.setLeft(new BSTNode<>(data, null, null));
        }
    }

    /**
     * 递归实现BST树的插入操作
     * @param data
     */
    public void insert(T data){
        this.root = insert(this.root, data);
    }

    /**
     *                     53
     *              36               86
     *          12      39      68         92
     *       10      23  37   46      79
     * @param root
     * @param data
     * @return
     */
    private BSTNode<T> insert(BSTNode<T> root, T data) {
        if(root == null){
            return new BSTNode<>(data, null, null);
        }
        if(root.getData().compareTo(data) > 0){
            root.setLeft(insert(root.getLeft(), data));
        } else if(root.getData().compareTo(data) < 0){
            root.setRight(insert(root.getRight(), data));
        }
        return root;
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

    /**
     * 递归实现BST树节点的删除
     * @param data
     */
    public void remove(T data){
        this.root = remove(this.root, data);
    }

    private BSTNode<T> remove(BSTNode<T> root, T data) {
        if(root == null){
            return null;
        }

        if(root.getData().compareTo(data) > 0){
            root.setLeft(remove(root.getLeft(), data));
        } else if(root.getData().compareTo(data) < 0){
            root.setRight(remove(root.getRight(), data));
        } else {
            if(root.getLeft() != null && root.getRight() != null){
                BSTNode<T> pre = root.getLeft();
                while(pre.getRight() != null){
                    pre = pre.getRight();
                }
                root.setData(pre.getData());
                // 递归继续删除前驱节点
                root.setLeft(remove(root.getLeft(), pre.getData()));
            } else {
                if(root.getLeft() != null){
                    return root.getLeft();
                } else if(root.getRight() != null){
                    return root.getRight();
                } else {
                    return null;
                }
            }
        }
        return root;
    }

    /**
     * 非递归查询操作
     * @param data
     * @return
     */
    public boolean non_query(T data){
        BSTNode<T> cur = this.root;
        while(cur != null){
            if(cur.getData().compareTo(data) > 0){
                cur = cur.getLeft();
            } else if(cur.getData().compareTo(data) < 0){
                cur = cur.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 求BST树的镜像问题
     */
    public void mirror(){
        mirror(this.root);
    }

    private void mirror(BSTNode<T> root) {
        if(root == null){
            return;
        }

        BSTNode<T> tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

        mirror(root.getLeft());
        mirror(root.getRight());
    }

    /**
     * 把BST树中满足[begin, end]区间的元素打印出来
     * @param begin
     * @param end
     */
    public void findAreaDatas(T begin, T end){
        findAreaDatas(this.root, begin, end);
        System.out.println();
    }

    private void findAreaDatas(BSTNode<T> root, T begin, T end) {
        if(root == null){
            return;
        }

        if(root.getData().compareTo(begin) > 0){ // 优化二叉树遍历
            findAreaDatas(root.getLeft(), begin, end);
        }

        if(root.getData().compareTo(begin) >= 0
            && root.getData().compareTo(end) <= 0){
            System.out.print(root.getData() + " ");
        }

        if(root.getData().compareTo(end) < 0){ // 优化二叉树遍历
            findAreaDatas(root.getRight(), begin, end);
        }
    }

    /**
     * 判断一个二叉树是否是BST树，是BST返回true，否则返回false
     */
    public boolean isBSTree(){
        //return isBSTree(this.root);
        T value = null;
        return isBSTree(this.root, value);
    }

    private boolean isBSTree(BSTNode<T> root, T value) {
        if(root == null){
            return true;
        }

        if(!isBSTree(root.getLeft(), value)){
            return false;
        }

        if(value != null && root.getData().compareTo(value) < 0){
            return false;
        }
        value = root.getData();

        return isBSTree(root.getRight(), value);
    }

    private boolean isBSTree(BSTNode<T> root) {
        if(root == null){
            return true;
        }

        // 中间判断，是判断异常情况，还是判断正常情况
        if(root.getLeft() != null
            && root.getLeft().getData().compareTo(root.getData()) > 0)
        {
            return false;
        }

        if(root.getRight() != null
            && root.getRight().getData().compareTo(root.getData()) < 0){
            return false;
        }

        return isBSTree(root.getLeft()) && isBSTree(root.getRight());

    }

    /**
     * 求data1和data2的最近公共祖先节点，返回它的值
     * @param data1
     * @param data2
     * @return
     */
    public T getLCA(T data1, T data2){
        if(this.root == null){
            return null;
        }
        if(!non_query(data1) || !non_query(data2)){
            return null;
        }
        return getLCA(this.root, data1, data2);
    }

    private T getLCA(BSTNode<T> root, T data1, T data2) {
        if(root == null){
            return null;
        }

        if(root.getData().compareTo(data1) > 0
                && root.getData().compareTo(data2) > 0){
            return getLCA(root.getLeft(), data1, data2);
        } else if(root.getData().compareTo(data1) < 0
                && root.getData().compareTo(data2) < 0){
            return getLCA(root.getRight(), data1, data2);
        } else {
            return root.getData();
        }
    }

    /**
     * 返回中序遍历倒数第k个节点的值
     * @param k
     * @return
     */
    public T getOrderKValue(int k){
        //int num = number(); // 1 2 3 4 5 6 7    7-3=4  9
        return getOrderKValue(this.root, k);
    }

    private int i=1;
    private T getOrderKValue(BSTNode<T> root, int k) {
        if(root == null){
            return null;
        }

        T value = getOrderKValue(root.getRight(), k);
        if(value != null){
            return value;
        }

        if(i++ == k){
            return root.getData();
        }

        return getOrderKValue(root.getLeft(), k);
        /*T value = getOrderKValue(root.getLeft(), k);
        if(value != null){
            return value;
        }

        if(i++ == k) {
            return root.getData();
        }

        return getOrderKValue(root.getRight(), k);*/
    }

    /**
     * 判断参数tree是不是当前bst树的一颗子树
     * @param tree
     * @return
     */
    public boolean isChildTree(BSTree<T> tree){
        BSTNode<T> cur = this.root;
        while(cur != null){
            if(cur.getData().compareTo(tree.root.getData()) > 0){
                cur = cur.getLeft();
            } else if(cur.getData().compareTo(tree.root.getData()) < 0){
                cur = cur.getRight();
            } else {
                break;
            }
        }

        if(cur == null){
            return false;
        }

        return isChildTree(cur, tree.root);
    }

    private boolean isChildTree(BSTNode<T> f, BSTNode<T> c) {
        if(f == null && c == null){
            return true;
        }

        if(f == null){
            return false;
        }

        if(c == null){
            return true;
        }

        if(f.getData().compareTo(c.getData()) != 0){
            return false;
        }

        return isChildTree(f.getLeft(), c.getLeft())
                && isChildTree(f.getRight(), c.getRight());
    }

    /**
     * 判断一个BST树是否是AVL树
     * @return
     */
    public boolean isAVLTree(){
        return false;
    }

    /**
     * 递归实现BST数的前序遍历API接口
     */
    public void preOrder(){
        System.out.print("递归前序遍历：");
        preOrder(this.root);
        System.out.println();
    }

    /**
     * 前序遍历递归实现
     * @param root
     */
    private void preOrder(BSTNode<T> root) {
        if(root != null){
            System.out.print(root.getData() + " "); // V
            preOrder(root.getLeft()); // L
            preOrder(root.getRight()); // R
        }
    }

    /**
     * 递归实现BST数的中序遍历API接口
     */
    public void inOrder(){
        System.out.print("递归中序遍历：");
        inOrder(this.root);
        System.out.println();
    }

    /**
     * 递归实现BST数的中序遍历的递归操作
     * @param root
     */
    private void inOrder(BSTNode<T> root) {
        if(root != null){
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    /**
     * 递归实现BST数的后序遍历API接口
     */
    public void postOrder(){
        System.out.print("递归后序遍历：");
        postOrder(this.root);
        System.out.println();
    }

    /**
     * 递归实现BST数的后序遍历的递归操作
     * @param root
     */
    private void postOrder(BSTNode<T> root) {
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * 递归实现BST树的层序遍历API接口
     */
    public void levelOrder(){
        System.out.print("递归层序遍历：");
        int l = level();
        for (int i = 0; i < l; i++) {
            levelOrder(this.root, i);
        }
        System.out.println();
    }

    private void levelOrder(BSTNode<T> root, int i) { // 5
        if(root == null){
            return;
        }

        if(i == 0){
            System.out.print(root.getData() + " ");
            return;
        }

        levelOrder(root.getLeft(), i-1);
        levelOrder(root.getRight(), i-1);
    }

    /**
     * 返回BST树节点个数的API接口
     * @return
     */
    public int number(){
        return number(this.root);
    }

    /**
     * 以参数root为根节点，计算BST树节点的个数
     * @param root
     * @return
     */
    private int number(BSTNode<T> root) {
        if(root == null){
            return 0;
        } else {
            return number(root.getLeft()) + number(root.getRight()) + 1;
        }
    }

    /**
     * 求BST树层数的API接口
     * @return
     */
    public int level(){
        return level(this.root);
    }

    /**
     * 以传入的参数root为根节点，计算二叉树的层数
     * @param root
     * @return
     */
    private int level(BSTNode<T> root) {
        if(root == null){
            return 0;
        } else {
            int left = level(root.getLeft());
            int right = level(root.getRight());
            return left > right ? left+1 : right+1;
        }
    }

    /**
     * 根据BST树的前序和中序，重建二叉树
     * @param pre
     * @param in
     */
    public void rebuild(T[] pre, T[] in) {
        this.root = rebuild(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private BSTNode<T> rebuild(T[] pre, int i, int j,
                               T[] in, int m, int n) {
        if(i > j || m > n){
            return null;
        }

        BSTNode<T> node = new BSTNode<>(pre[i], null, null);
        for(int k=m; k<=n; ++k){
            if(in[k].compareTo(pre[i]) == 0){ // k
                node.setLeft(rebuild(pre, i+1, i+(k-m), in, m, k-1));
                node.setRight(rebuild(pre, i+(k-m)+1, j, in, k+1, n));
                break;
            }
        }
        return node;
    }
}

/**
 * Hello world!
 *
 */
public class BSTTestUnit
{

    public void test03(){
        BSTree<Integer> bst = new BSTree<>();
        int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int val : ar) {
            bst.insert(val);
        }

        bst.preOrder();
        bst.inOrder();

        Integer[] pre={53, 36, 12, 23, 39, 46, 86, 68, 79, 92, 98};
        Integer[] in={12, 23, 36, 39, 46, 53, 68, 79, 86, 92, 98};
        BSTree<Integer> bst1 = new BSTree<>();
        bst1.rebuild(pre, in);
        bst1.preOrder();
        bst1.inOrder();


        /*BSTree<Integer> bst1 = new BSTree<>();
        bst1.root = new BSTNode<>(86, null, null);
        BSTNode<Integer> node1 = new BSTNode<>(68, null, null);
        BSTNode<Integer> node2 = new BSTNode<>(93, null, null);
        bst1.root.setLeft(node1);
        bst1.root.setRight(node2);

        System.out.println(bst.isChildTree(bst1));*/

        /*BSTNode<Integer> node3 = new BSTNode<>(10, null, null);
        BSTNode<Integer> node4 = new BSTNode<>(30, null, null);
        node1.setLeft(node3);
        node1.setRight(node4);*/
    }

    public void test02(){
        BSTree<Integer> bst = new BSTree<>();
        bst.root = new BSTNode<>(40, null, null);
        BSTNode<Integer> node1 = new BSTNode<>(20, null, null);
        BSTNode<Integer> node2 = new BSTNode<>(80, null, null);
        bst.root.setLeft(node1);
        bst.root.setRight(node2);

        BSTNode<Integer> node3 = new BSTNode<>(10, null, null);
        BSTNode<Integer> node4 = new BSTNode<>(30, null, null);
        node1.setLeft(node3);
        node1.setRight(node4);

        BSTNode<Integer> node5 = new BSTNode<>(50, null, null);
        BSTNode<Integer> node6 = new BSTNode<>(90, null, null);
        node2.setLeft(node5);
        node2.setRight(node6);

        System.out.println(bst.isBSTree());
    }


    public void test01(){
        /**
         *                     53
         *              36               86
         *          12      39      68         92
         *             23  37   46      79           98
         *
         */
        BSTree<Integer> bst = new BSTree<>();
        int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int val : ar) {
            bst.non_insert(val);
        }
        bst.non_insert(37);
        //bst.non_remove(86);
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
        bst.levelOrder();
        System.out.println(bst.number());
        System.out.println(bst.level());

        //bst.mirror();
        //bst.inOrder();
        bst.findAreaDatas(36, 50);
        System.out.println(bst.isBSTree());
        System.out.println(bst.getLCA(12, 36));
        System.out.println(bst.getOrderKValue(6));
        System.out.println();
    }
}
