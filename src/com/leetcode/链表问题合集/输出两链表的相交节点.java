package src.com.leetcode.链表问题合集;

public class 输出两链表的相交节点 {
    public int getListNodeLength(ListNode L1) {
        int num = 0;
        while (L1 != null) {
            ++num;
            L1 = L1.next;
        }
        return num;
    }

    public ListNode Intersect(ListNode pHead1, ListNode pHead2) {
        ListNode L1 = pHead1;
        ListNode L2 = pHead2;
        int L1_num = getListNodeLength(L1);
        int L2_num = getListNodeLength(L2);

        if (L1_num > L2_num) {
            for (int i = (L1_num - L2_num); (L1_num - L2_num) > 0; i--) {
                L1 = L1.next;
            }
        } else if (L1_num < L2_num) {
            for (int i = (L2_num - L1_num); (L2_num - L1_num) > 0; i--) {
                L2 = L2.next;
            }
        }

        while (L1 != null && L2 != null) {
            if (L1 == L2) {
                return L1;
            }
            L1 = L1.next;
            L2 = L2.next;
        }
        return null;
    }


}
