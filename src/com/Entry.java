package src.com;

public class Entry {
    private int value;
    private Entry next;

    public  Entry(int value){
        this.value = value ;
    }
    public  Entry(){}
    public Entry getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}

