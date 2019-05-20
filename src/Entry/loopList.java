package src.Entry;

public class loopList<T> {
    private Entry<T> head;
    private Entry<T> tail;
    private int size;

    public loopList() {
        head = tail = null;
        this.size = 0;
    }

    /**
     * 返回节点的数量
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断插入的位置是否越界
     *
     * @param num
     * @return
     */
    public boolean isExist(int num) {
        if (num >= 0 && num <= size)
            return true;
        else
            return false;

    }

    public Entry<T> getEntryBYnum(int num) {
        Entry<T> cur = head;
        if (num == 1)
            return head;
        for (int i = 1; i <= num - 1; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * 插入操作
     *
     * @param value
     */
    public boolean add(T value, int num) {
        if (isExist(num) == false)
            return false;
        Entry<T> next = getEntryBYnum(num);
        Entry<T> P = new Entry<>(value);
        P.setNext(next);
        P.setPre(next.getPre());
        next.getPre().setNext(P);
        next.setPre(P);


        this.size -= 1;
        return true;
    }

    /**
     * 删除值为value的节点
     *
     * @param value
     */
    public void remove(T value) {
        Entry<T> P = head;
        for (; P == (tail.getNext()); P = P.getNext()) {
            if (P.getValue() == value) {
                P.getPre().setNext(P.getNext());
                P.getNext().setPre(P.getPre());
                this.size -= 1;
            }
        }
    }

    public void show() {
        Entry<T> P = head;
        System.out.println("[");
        for (; P == (tail.getNext()); P = P.getNext()) {
            System.out.println(P.getValue() + ",");
        }
        System.out.println("]");

    }
}
