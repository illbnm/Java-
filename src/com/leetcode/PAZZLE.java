package src.com.leetcode;

import java.util.Random;
import java.util.Stack;

/**
 * 初始正方形中的带圆圈的数字是可以移动到沿着行的其他正方形的标记。 在拼图的每个步骤，可以移动标记的正方形中由当前占据的整数指示的方格数。 标记可以沿着该行向左或向右移动，但可以不移动经过任一端。 例如，唯一合法的第一步是将标记向右移动三个方格，因为没有空间向左移动三个空格。
 * <p>
 * 拼图的目标是将标记移动到行的远端的0。
 * <p>
 * 要求： 用递归 或 栈或者队列实现编程。
 * 如果圆圈能够移动到最后0的位置，返回true，否则返回false。
 * 程序要适应任何大小的方格数，并且方格里的数字是随机的，范围是[1,9]。
 * 如何检测不能解决的结构，是否存在可以改善执行时间的方法。
 * 程序运行，需要输入随机的方格数，然后打印出方格，再打印详细的移动路径。
 */
class Node {
    int Node_i;
    int value;
    boolean signLeft;
    boolean signright;

    public Node(int value, int i) {
        this.value = value;
        this.Node_i = i;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSignLeft() {
        return signLeft;
    }

    public void setSignLeft(boolean signLeft) {
        this.signLeft = signLeft;
    }

    public boolean isSignright() {
        return signright;
    }

    public void setSignright(boolean signright) {
        this.signright = signright;
    }

    public Node(int value) {
        this.value = value;
    }
}

public class PAZZLE {
    private Stack<Node> N = new Stack<Node>();
    boolean[] Stack_num = new boolean[10];


    public boolean JudgeLeft(Node node, int I) {
        if (node.value > I && (node.Node_i - node.value) < 0)
            node.signLeft = false;
        else
            node.signLeft = true;
        return node.signLeft;
    }

    public boolean JudgeRight(Node node, int I) {
        int num = 10;
        if (node.value > I && (node.value + node.Node_i) < num)
            node.signright = true;
        else
            node.signright = false;
        return node.signright;
    }

    public boolean isPush(Node node) { //此处判断是否当前要push的Node已经入过栈,也就是说每个节点在同一时刻只能进一次栈,保证栈中的元素唯一

        for (int i = 0; i < 10; i++) {
            if (Stack_num[node.Node_i] == true)
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean run(Node[] nodes, int num) {
        if (nodes[0].value == 0)
            return false;
        N.push(nodes[0]);
        while (N.isEmpty() == false) {
            Node top = N.peek();
            if (top.value == 0)
                return true;
            if (JudgeLeft(top, top.Node_i)) {
                if (isPush(top) == false) {
                    N.push(nodes[top.Node_i - top.value]);

                    //将下一个能调的点入栈
                    top.signLeft = false;
                    Stack_num[top.Node_i] = true;//并且封死当前节点的右半边
                } else
                    return false;

            } else if (JudgeRight(top, top.Node_i)) {
                if (isPush(top) == false) {             //此处去重判断当前节点是否被入栈,以下标来判断
                    N.push(nodes[top.Node_i + top.value]);
                    top.signright = false;
                    Stack_num[top.Node_i] = true;
                } else
                    return false;
            } else
                N.pop();
        }
        return false;
    }

    public static void main(String[] args) {
        final int num = 10;
        Random random = new Random();
        Node[] nodes = new Node[num];
        int[] value = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(value[i], i);

        }
        //nodes[9] = new Node(0,9);
        PAZZLE MY = new PAZZLE();
        boolean isSuccess = MY.run(nodes, num);
        System.out.println(isSuccess);
    }
}
