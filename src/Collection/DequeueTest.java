package src.Collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeueTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList();
        Queue<String> queue = new LinkedList<>();
        deque.offer("hello");
        /**
         * 编译器将queue进行了强制转换
         */
        ((LinkedList<String>) queue).offerFirst("nihao");



    }
}
