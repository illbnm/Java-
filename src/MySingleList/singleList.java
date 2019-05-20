package src.MySingleList;

/**
 * Todo :带头单链表的实现
 */
public class singleList<T> {
    headEntry<T> head;

    public singleList() {
        head = new headEntry<T>(0, null, null);
    }

    /**
     * 单链表的头插法
     *
     * @param value
     */
    public void intsertHead(T value) {
        Entry<T> P = new Entry(value, this.head.getNext());
        head.setNext(P);
        head.size += 1;
    }

    /**
     * 单链表尾插法
     *
     * @param value
     */
    public void insertTail(T value) {
        Entry<T> P = head;
        while (P.getNext() != null)
            P = P.getNext();
        P.setNext(new Entry<>(value, null));
        head.size += 1;
    }

    /**
     * 打印单链表节点所有元素的值
     */

    public void show() {
       // Entry<T> P = head;
//
//        while (P.getNext() != null) {
//            System.out.println(P.getValue() + "  ");
//            P = P.getNext();
//        }
       // System.out.println(P.getValue() + "   ");
        for (Entry<T> P = head; P != null; P = P.getNext()) {
            if (P == head) {
            } else
                System.out.println(P.getValue() + " ");
        }
    }

    /**
     * 获取链表节点的个数
     *
     * @return
     */
    public int getSize() {
        return this.head.size;
    }

    /**
     * 头删法
     */
    public void removeHead() {
        if (head.getNext() == null) {
            return;
        }
        Entry<T> P = head.getNext();
        head.setNext(P.getNext());
        P.setNext(null);        //做完删除操作,将P节点的value与next都置空,防止内存泄漏
        P.setValue(null);
    }

    /**
     * 尾删法
     */
    public void removeTail() {
        Entry<T> P = head;
        if (P.getNext() == null) {
            return;
        }
        while (P.getNext().getNext() != null) {
            P = P.getNext();
        }
        P.getNext().setValue(null);    //防止内存泄漏
        P.setNext(null);
        head.size -= 1;

    }

    /**
     * 删除值为value的节点
     *
     * @param value
     */
    public void remove(T value) {
        Entry<T> pre = head;
        Entry<T> cur = head.getNext();
        while (cur.getNext() != null) {
            if (cur.getValue() == value) {
                pre = cur.getNext();
                cur = cur.getNext();
                this.head.size -= 1;
            } else {
                pre = cur;
                cur = cur.getNext();
            }

        }


    }

    public static void main(String[] args) {

        singleList<Integer> list = new singleList<>();
        list.insertTail(1);
        //list.insertTail(2);
//        list.insertTail(3);
//        list.intsertHead(4);
        list.show();
    }
}
