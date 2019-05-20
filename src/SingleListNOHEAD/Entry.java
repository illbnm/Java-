package src.SingleListNOHEAD;

public class Entry<T> {
    private T value;
    private Entry<T> next;

    public Entry(T value) {
        this.value = value;
        this.next = null;
    }

    public Entry(T value, Entry<T> next) {
        this.next = next;
        this.value = value;
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
