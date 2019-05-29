package src.com.leetcode.链表问题合集;

public class 删除重复链表 {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode P = pHead.next;
        if (P == null) {
            return null;
        }
        if (P.next == null) {
            return P;
        }
        while (P != null) {
            ListNode curhead = null;
            curhead = pHead;
            if (P.next == curhead) {
                curhead = P;
            }


        }

        return pHead;
    }
}