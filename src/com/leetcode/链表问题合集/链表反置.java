package src.com.leetcode.链表问题合集;

/**
 * 无头结点链表的反置
 */
public class 链表反置 {
    public static ListNode ReverseList(ListNode head) {
        if(head == null ){
            return null;
        }
        if (head.next == null)
            return head;
        ListNode P = head.next;
        head.next= null;

        ListNode S = null;
        while (P != null) {
            S = P.next; //保存P下一节点信息,防止之后的节点丢失
            P.next = head;
            head = P;
            P = S;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            list[i] = new ListNode(i);
        }
        ReverseList(list[0]);

    }
}
