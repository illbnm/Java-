package src.MySingleList;

public class headEntry<T> extends Entry<T> {
    int size;

    public headEntry(int size, T value, Entry<T> next) {
        super(value,next);
        this.size = size;
    }
}
