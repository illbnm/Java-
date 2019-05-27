package src.SingleListNOHEAD;

public class Link<T> {
    private class Entry<E>{
        private E value;
        private Entry<E> next;
        public Entry(E value){
            this.value = value;

        }
    }
    public void fun(T value){
        Entry<T> entr = new Entry<>(value);
        entr.value = null;
    }

    private Entry<T> headEntry;
    private Entry<T> tailEntry;
    public Link(){
    }
    public void addHead(T value){
        Entry<T> newEntry = new Entry<>(value);
        if(headEntry == null){
            headEntry = newEntry;
            tailEntry = newEntry;
        }else{
            newEntry.next = headEntry;
            headEntry = newEntry;//新头
        }
    }
    public void addTail(T value){
        Entry<T> newEntry = new Entry<>(value);
        if(headEntry == null){
            headEntry = newEntry;
            tailEntry = newEntry;
        }else{
            tailEntry.next = newEntry;
            tailEntry = newEntry;//更新新尾
        }
    }
    public void deleteHead(){
        if(headEntry == null){
            return;
        }
        Entry<T> p = headEntry;
        headEntry = headEntry.next;
        p.value = null;
        p.next = null;
    }
    private Entry<T> searchPrio(){
        for(Entry<T> p = headEntry;p!=null;p=p.next){
            if(p.next == tailEntry){
                return p;
            }
        }
        return null;
    }
    public void deleteTail(){
        Entry<T> prio = searchPrio();
        if(prio == null){
            return;
        }
        prio.next = null;
        tailEntry.value = null;
        tailEntry = prio;
    }
    public void show() {
        for(Entry<T> p = headEntry;p!=null;p=p.next){
            System.out.print(p.value +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Link link = new Link();
        link.addHead(1);
        link.addHead(2);
        link.addHead(4);
        link.addTail(3);
        link.show();
    }
}