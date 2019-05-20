package src.SingleListNOHEAD;

/**
 *
 * @author MIMO
 * @date 2019年5月20日 17:10:38
 * @param <T>
 */
public class linkList<T> {

    private Entry<T> head, tail;
    private int size;

    public linkList() {
        head = tail = null;
        size = 0;
    }

    /**
     * 获取当前链表的长度
     *
     * @return
     */
    public int siee() {
        return this.size;
    }

    /**
     * 头插法
     *
     * @param value
     */
    public void addHead(T value) {
        Entry<T> P = new Entry<>(value);
        if (head == null) {
            head = tail = P;
            this.size += 1;
        } else {
            P.setNext(head);
            head = P;
            this.size += 1;
        }

    }

    /**
     * 尾插法
     *
     * @param value
     */
    public void addTail(T value) {
        Entry<T> P = new Entry<>(value);
        if (head == null) {
            head = tail = P;
        } else {
            tail.setNext(P);
            tail = P;
        }
        this.size += 1;
    }

    /**
     * 删除值为vlaue的节点
     *
     * @param value
     */
    public void remove(T value) {
        Entry<T> P = head;

        for (; P != null; P = P.getNext()) {
            if (head.getValue() == value) {
                head = head.getNext();
            } else if (P.getNext().getValue() == value) {
                if (P.getNext().getNext() != null) {
                    P.setNext(P.getNext().getNext());

                } else {
                    P.setNext(null);
                }
            }
        }


    }

    public void show() {
        System.out.println("[");
        for (Entry<T> P = head; P != null; P = P.getNext()) {
            System.out.println(P.getValue() + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

    }
}