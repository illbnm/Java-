package src.com;

import java.util.Map;

/**
 * 实现顺序表的头插尾插
 */

public class SingleLink {
    private Entry head = new Entry();

    public void addHead(int value) {
        Entry P = new Entry(value);
        Entry HeadNext = head.getNext();

        P.setNext(HeadNext);
        head.setNext(P);

    }

    public void addTail(int value) {
        Entry P = head;
        Entry N = new Entry(value);
        while (P.getNext() != null) {
            P = P.getNext();    //找到最后一个节点并保存到P
        }
        P.setNext(N);
        N.setNext(null);

    }

    public void deleteHead() {
        head = head.getNext();   //直接将head的下一个节点变为头节点
    }

    public void deleteTail() {
        Entry P = head;
        while (P.getNext().getNext() != null) {
            P = P.getNext();
        }
        P.setNext(null);
    }

    public void deleteValue(int value) {
        Entry P = head;
        Entry T = new Entry();
        while (P.getNext() != null) {
            if (P.getNext().getValue() == value) {  //此处P是相等节点的前一个节点
                T = P.getNext();  //保存的是相等的节点
                P.setNext(T.getNext()); //此处是将相等节点的下一个节点给P.Next

            } else {
                P = P.getNext();
            }

        }
    }

    public void show() {
        for (Entry P = head; P != null; P = P.getNext()) {
            System.out.println(P.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        singleLink.addHead(1);
        singleLink.addHead(2);
        singleLink.addHead(3);
        singleLink.addHead(4);
        singleLink.addHead(4);
        singleLink.addTail(4);

        singleLink.deleteValue(4);
        singleLink.show();
        System.out.println("******************");
        singleLink.deleteTail();
        singleLink.show();
//        singleLink.deleteHead();
//        singleLink.show();
    }
}
