package src.com.leetcode.链表问题合集;

public class 合并两个链表 {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = null;
        if (list1 == null && list2 == null)
            return head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode P = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                P.next = list1;
                P = P.next;
                list1 = list1.next;
            } else {
                P.next = list2;
                P = P.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            P.next = list1;
        }
        if (list2 != null) {
            P.next = list2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode head = Merge(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
