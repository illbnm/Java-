package src.com.leetcode.链表问题合集;

/**
 * length = ListNode.length - k  length为正数节点数
 */
public class 找倒数K节点 {
    public static  ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) {
            return null;
        }
        if (head.next == null && k == 1) {
            return head;
        }

        for (int i = 1; i <= k - 1; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next!= null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode  list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);

        list = FindKthToTail(list,1);
        System.out.println(list.val);

    }
}
