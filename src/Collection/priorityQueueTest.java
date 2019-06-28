package src.Collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> Pqueue = new PriorityQueue<>();
        Pqueue.offer(99);
        Pqueue.offer(1);
        Pqueue.offer(45);
        Pqueue.offer(33);
        Pqueue.offer(12);
        for (Integer a : Pqueue) {    //只进行了一次建堆的过程,并没有用完整的堆排序的过程
            System.out.print(a + "  " );
        }
        Pqueue.peek();






    }
}
