package src.高级数据结构;

/**
 * 1. AVL 是不是平衡树 ? 平衡是什么意思 ?
 * 2 . AVL 树是不是一棵搜索树 ?
 * 3. AVL几种旋转操作说一下 ?
 * 4.AVL树的最差 最好 平均的增删插 O(log2N)
 * 5. AVL的最差情况下,增加删除需要旋转多少次 ? 树的高度次 log2 (N)
 *
 * @param <T>
 */
class AVLNode<T extends Comparable<T>> {
    private T data;
    private AVLNode<T> Left;
    private AVLNode<T> Right;
    private int Height;

    public T getData() {
        return data;
    }

    public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int height) {
        this.data = data;
        Left = left;
        Right = right;
        Height = height;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeft() {
        return Left;
    }

    public void setLeft(AVLNode<T> left) {
        Left = left;
    }

    public AVLNode<T> getRight() {
        return Right;
    }

    public void setRight(AVLNode<T> right) {
        Right = right;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
}

public class AVL<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVL() {
        this.root = null;
    }

    /**
     * 以参数node为根节点进行左旋转操作，并把旋转后的子树的根节点返回
     *
     * @param node
     * @return
     */
    private AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> child = node.getRight();
        node.setRight(child.getLeft());
        child.setLeft(node);
        node.setHeight(maxHeight(node.getLeft(), node.getRight()) + 1);
        child.setHeight(maxHeight(child.getLeft(), child.getRight()) + 1);
        return child;
    }

    private int maxHeight(AVLNode<T> node1, AVLNode<T> node2) {
        int h1 = height(node1);
        int h2 = height(node2);
        return h1 > h2 ? h1 : h2;
    }

    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.getHeight();
    }


    /**
     * 以参数node为根节点进行右旋转操作，并把旋转后的子树的根节点返回
     * @param node
     * @return
     */
//    private AVLNode<T> rightRotate(AVLNode<T> node){
//        AVLNode child = node.getLeft();
//    }
//
//    /**
//     * 以参数node为根节点进行左平衡操作，并把平衡后的子树的根节点返回
//     * @param node
//     * @return
//     */
//    private AVLNode<T> leftBalance(AVLNode<T> node){
//
//    }
//
//    /**
//     * 以参数node为根节点进行右平衡操作，并把平衡后的子树的根节点返回
//     * @param node
//     * @return
//     */
//    private AVLNode<T> rightBalance(AVLNode<T> node){
//
//    }

    /**
     * 插入
     * 旋转最差的情况是log(2)N
     */
    public AVLNode<T> insert(AVLNode<T> root, T data) {
        if (root == null) {
            return new AVLNode<>(data, null, null, 1);
        }
        //
        if (root.getData().compareTo(data) > 0) {
            root.setLeft(insert(root.getLeft(), data));
            //左子树太高
            if (height(root.getLeft()) - height(root.getRight()) > 1) {
                // 左孩子的左子树太高
                if (height(root.getLeft().getLeft()) >= height(root.getLeft().getRight())) {
                    // root = rightRotate(root);
                } else { // 左孩子的右子树太高
                    root = leftRotate(root);
                }
            }
        } else if (root.getData().compareTo(data) < 0) {
            root.setRight(insert(root.getRight(), data));

        }

        root.setHeight(maxHeight(root.getLeft(), root.getRight()) + 1);
        return root;
    }

    /**
     * remove递归实现AVL的删除操作
     */

    public void remove(T data) {
        this.root = remove(this.root, data);
    }

    private AVLNode<T> remove(AVLNode<T> root, T data) {
        if (root == null) {
            return null;
        }

        if (root.getData().compareTo(data) > 0) {
            root.setLeft(remove(root.getLeft(), data));
            // #1
            if (height(root.getRight()) - height(root.getLeft()) > 1) {
                if (height(root.getRight().getRight())
                        >= height(root.getRight().getLeft())) {
                    // 右孩子的右子树太高
                    root = leftRotate(root);
                } else {
                    // 右孩子的左子树太高
                    // root = rightBalance(root);
                }
            }
        } else if (root.getData().compareTo(data) < 0) {
            root.setRight(remove(root.getRight(), data));
            // #2
            if (height(root.getLeft()) - height(root.getRight()) > 1) {
                if (height(root.getLeft().getLeft())
                        >= height(root.getLeft().getRight())) {
                    // 左孩子的左子树太高
                    // root = rightRotate(root);
                } else {
                    // 左孩子的右子树太高
                    //  root = leftBalance(root);
                }
            }
        } else {
            if (root.getLeft() != null && root.getRight() != null) {
                // #3
                if (height(root.getLeft()) >= height(root.getRight())) {
                    // 用前驱节点代替
                    AVLNode<T> pre = root.getLeft();
                    while (pre.getRight() != null) {
                        pre = pre.getRight();
                    }
                    root.setData(pre.getData());
                    root.setLeft(remove(root.getLeft(), pre.getData()));
                } else {
                    // 用后继节点代替
                    AVLNode<T> post = root.getRight();
                    while (post.getLeft() != null) {
                        post = post.getLeft();
                    }
                    root.setData(post.getData());
                    root.setRight(remove(root.getRight(), post.getData()));
                }
            } else {
                if (root.getLeft() != null) {
                    return root.getLeft();
                } else if (root.getRight() != null) {
                    return root.getRight();
                } else {
                    return null;
                }
            }
        }

        // #4 在递归回溯的过程中更新节点的高度值
        root.setHeight(maxHeight(root.getLeft(), root.getRight()) + 1);
        return root;
    }


    /**
     * 判断一个BST数是否为AVL树
     * isAVLtree
     */
    public void isAVLTree() {
        int i = isAVLTree(this.root);
    }

    private int isAVLTree(AVLNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            int left = isAVLTree(root.getLeft());
            int right = isAVLTree(root.getRight());
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }
            return left > right ? left + 1 : right + 1;
        }
    }
    /**
     *
     */


}
