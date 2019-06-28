package src.Collection;
import  java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkListtest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add(1, "world");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        /**
         * 获取迭代器
         */
        Iterator<String> ls = linkedList.iterator();   //获取迭代器,只能向后遍历
        while (ls.hasNext()) {
            System.out.println(ls.next());
        }
        ListIterator<String> LinkIterator = linkedList.listIterator(3);  // 可以设定初值,而且可向前向后遍历
        while (LinkIterator.hasPrevious()) {
            System.out.println(LinkIterator.previousIndex());
        }
        while (LinkIterator.hasNext()) {
            System.out.println(LinkIterator.next());
        }

        /**
         * get&set和ArrayList使用相同
         */

//删除    有LinkedList本身提供的,也有ListIterator提供的


    }


}
