package src.Doublylinkedlist;

public class Entry<T> {
    private T value;
    private Entry<T> next;
    private Entry<T> pre;

    public Entry<T> getPre() {
        return pre;
    }

    public void setPre(Entry<T> pre) {
        this.pre = pre;
    }

    public Entry(T value, Entry<T> pre, Entry<T> next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Entry<T> getNext() {
        return next;
    }

    public void setNext(Entry<T> next) {
        this.next = next;
    }
}
