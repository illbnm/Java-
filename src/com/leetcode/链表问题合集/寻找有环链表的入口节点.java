package src.com.leetcode.链表问题合集;

public class 寻找有环链表的入口节点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead.next == pHead)
            return pHead;
        int fast_num = 0;
        int Phead_num = 0;
        ListNode fast = pHead;
        while (fast != null) {
            pHead = pHead.next;
            Phead_num += 1;
            fast = fast.next.next;

        }

        return pHead;
    }
}
