package src.多线程;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Myvector {
    private Integer[] elments;
    int size;
    int capcity;
    int capcityIcreatment;
    private ReadWriteLock lock;

    public Myvector(int capcity, int capcityIcreatment) {
        this.elments = new Integer[capcity];
        this.size = 0;
        this.capcity = capcity;
        this.capcityIcreatment = capcityIcreatment;
        this.lock = new ReentrantReadWriteLock();
    }


    public void add(Integer vlaue) {
        try {
            lock.writeLock().lock();
            if (size >= capcity) {
                //扩容
            }
            elments[size] = vlaue;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public Integer get(int index) {
        try {
            lock.readLock().lock();
            if (index > size && index < 0) {
                throw new IndexOutOfBoundsException();

            }
            return elments[index];
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {

    }
}
