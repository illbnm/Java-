package src.高级数据结构;

/**
 * AVL >>>>> 红黑树 (保证增删查效率 O(log 2 N ),但是旋转的次数更少了)
 * 红黑树是不是一棵二叉搜索树 ?  是
 * 红黑树是不是一棵平衡树 ? 不是
 * 红黑树的插入最多旋转两次,删除最多旋转3次
 * 红黑树左右节点子树高度差,长的不能超过短的两倍
 * <p>
 * 红黑树的五个性质 :
 * 1 . 每一个节点都有颜色, 黑色/红色
 * 2. 叶子节点(null 孩子) 黑色
 * 3. 根节点必须是黑色
 * 4. 不能出现连续的红色节点
 * 5. 从  根节点到任意一个叶子节点上的路径上    的  黑色节点  的数量  是相同的
 */
enum Color {
    BLACK, RED
}

class RBNode<T extends Comparable<T>> {
    private T data;
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private Color color;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RBNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBNode<T> left) {
        this.left = left;
    }

    public RBNode<T> getRight() {
        return right;
    }

    public void setRight(RBNode<T> right) {
        this.right = right;
    }

    public RBNode<T> getParent() {
        return parent;
    }

    public void setParent(RBNode<T> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}


public class RBTreeTest<T extends Comparable<T>> {
    private RBNode<T> root;

    public RBTreeTest() {
        this.root = null;
    }


    /**
     * 左旋
     *
     * @param node
     */
    private void leftRotate(RBNode<T> node) {
        RBNode<T> child = node.getRight();
        child.setParent(node.getParent());
        if (node.getParent() == null) {
            this.root = child;
        } else {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(child);
            } else {
                node.getParent().setRight(child);
            }
        }

        node.setRight(child.getLeft());
        if (child.getLeft() != null) {
            child.getLeft().setParent(node);
        }

        child.setLeft(node);
        node.setParent(child);
    }

    /**
     * 右旋
     */
    public void rightRotate(RBNode<T> node) {
        RBNode<T> child = node.getLeft();
        if (node.getParent() == null) {
            this.root = child;
        } else {
            if (node.getParent().getLeft() == node) {   // 判断node的父节点的左节点是否为 node
                node.getParent().setLeft(child);
            }else {
                node.getParent().setRight(child);    // 判断是否为父节点的右孩子,并将child赋值
            }
        }
        node.setLeft(child.getRight());
       // if(child.getLeft() != null)


        child.setRight(node);


    }

/**
 *
 * 插入调整操作
 *
 */
public void insert(T data){}




}
