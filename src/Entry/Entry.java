package src.Entry;

public class Entry<T> {
    private T value;
    private Entry<T> pre;
    private Entry<T> next;

    public Entry(T value, Entry<T> pre, Entry<T> next) {
        this.next = next;
        this.pre = pre;
        this.value = value;
    }

    public Entry(T value) {
        this.value = value;
        pre = next = this;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Entry<T> getPre() {
        return pre;
    }

    public void setPre(Entry<T> pre) {
        this.pre = pre;
    }

    public Entry<T> getNext() {
        return next;
    }

    public void setNext(Entry<T> next) {
        this.next = next;
    }
}

