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
    int value;
    int sign = 0;

    public Node(int value) {
        this.value = value;
    }
}

public class PAZZLE {
    private Stack<Node> N = new Stack<Node>();

    public void run(Node[] nodes, int num) {
        int i = 1;

        N.push(nodes[0]);
        while (N.empty() == true) {
            if (N.search(nodes[9]) == 1)
                if (nodes[i].value < num - i || nodes[i].value < i) {
                    N.push(nodes[i]);
                    i = i + nodes[i].value;
                } else
                    N.pop();

        }
    }

    public static void main(String[] args) {
        final int num = 10;
        Random random = new Random();
        Node[] nodes = new Node[num];
        for (int i = 0; i < num - 1; i++) {
            nodes[i].value = random.nextInt(10);
        }
        nodes[9].value = 0;
    }
}
