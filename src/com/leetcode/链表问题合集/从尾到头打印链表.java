package src.com.leetcode.链表问题合集;


import java.util.ArrayList;


public class 从尾到头打印链表 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        if (listNode == null)
            return null;
        if(listNode.next == null ){
            list.add(listNode.val);
            return list;
        }
    list = printListFromTailToHead(listNode.next);
        list.add(listNode.val);

        return list;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        printListFromTailToHead(list);
    }
}
