package LinkedListProblems;

/**
 * Created by Administrator on 03-Jun-003.
 */
public class MergeTwoLists21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void main(String args[]){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(7);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;
        a4.next = a5;
        a5.next = null;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(10);
        b1.next = b2;
        b2.next = b3;
        b3.next = null;
        b4.next = b5;
        b5.next = null;
        System.out.println(mergeTwoLists(a1, b1));
        System.out.println("ad");
    }
}
