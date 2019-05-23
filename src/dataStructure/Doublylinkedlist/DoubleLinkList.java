package src.dataStructure.Doublylinkedlist;

/**
 * TODO : 双向链表的实现
 *
 * @param <T>
 */
public class DoubleLinkList<T> {
    Entry<T> head;

    public DoubleLinkList() {
        head = new Entry<>(null, null, null);
    }

    /**
     * 双向链表的头插法
     *
     * @param value
     */
    public void addHead(T value) {
        Entry<T> P = new Entry<>(value, head, head.getNext());
        head.setNext(P);
        if (P.getNext() != null) {
            P.getNext().setPre(P);
        }
    }

    /**
     * 双向链表的尾插法
     *
     * @param value
     */
    public void addTail(T value) {

        Entry<T> cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(new Entry<T>(value, cur, null));
    }

    /**
     * 删除值为Value的节点
     *
     * @param value
     */
    public void removeValue(T value) {
        Entry<T> cur = head.getNext();
        while (cur != null) {
            if (cur.getValue() == value) {
                cur.getPre().setNext(cur.getNext());
                if (cur.getNext() != null) {
                    cur.getNext().setPre(cur.getPre());    //防止空指针
                }
            }
            cur = cur.getNext();
        }
    }

    /**
     * 打印节点保存的值
     */
    public void Show() {
        Entry<T> cur = head.getNext();
        for (; cur != null; cur = cur.getNext()) {
            System.out.println(cur.getValue() + "   ");
        }
    }

    public static void main(String[] args) {
        DoubleLinkList <Integer> MYlist = new DoubleLinkList<>();
        MYlist.addHead(1);
        MYlist.addHead(2);
        MYlist.addTail(3);
        MYlist.Show();
        System.out.println("*********************************************");
        System.out.println("移除后 : ");
        MYlist.removeValue(2);
        MYlist.Show();
    }
}
