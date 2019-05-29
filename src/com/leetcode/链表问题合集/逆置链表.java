package src.com.leetcode.链表问题合集;

/**
 * 逆转箭头 用三个节点保存
 */
//public static ListNode ReverseList(ListNode head) {
//        if(head == null ){
//        return null;
//        }
//        if (head.next == null)
//        return head;
//        ListNode P = head.next;
//        head.next= null;
//
//        ListNode S = null;
//        while (P != null) {
//        S = P.next; //保存P下一节点信息,防止之后的节点丢失
//        P.next = head;
//        head = P;
//        P = S;
//        }
//        return head;
//        }
public class 逆置链表 {


    public ListNode ReverseList(ListNode head) {

        if(head == null || head.next ==null){
            return  head ;
        }
        ListNode pre = head;
        ListNode cru = pre.next;
        ListNode next = cru.next;
        head.next = null ;
        while (cru != null ) {
            cru.next = pre ;
            pre = cru ;
            cru = next;
            if(next != null)
                next = next.next;
        }
        return pre ;
    }


}
