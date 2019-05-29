package src.com.leetcode.链表问题合集;

public class 判断链表是否有环 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        if (head.next == head)
            return true;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null)
                return false;
            head = head.next;
            fast = fast.next.next;

            if (head == fast)
                return true;
        }
        return false;
    }
}
