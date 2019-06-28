package src.Collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueuePeople {
    public static void main(String[] args) {
        Queue<People> Q = new PriorityQueue<>();
        Q.offer(new People("wang", 19));
        Q.offer(new People("yun", 78));
        Q.offer(new People("lun", 56));
        Q.offer(new People("pun", 18));
        Comparator<People> COM = new ComparePeople();

        while (!Q.isEmpty()) {
            int age = Q.poll().getAge();
            System.out.print(age + "    ");
        }
    }


}
class ComparePeople implements Comparator<People>{
    @Override
    public int compare(People o1, People o2) {
        return o1.getAge()-o2.getAge();
    }
}

class People implements Comparable<People>{
    private String name;
    private int age;

    public People(String name, int age) {
        this.age = age;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(People o) {
     return this.age - o.age;
    }


}