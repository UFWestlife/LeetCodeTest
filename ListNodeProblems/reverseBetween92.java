package ListNodeProblems;

/**
 * Created by Administrator on 16-May-016.
 */
public class reverseBetween92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //first part
        ListNode mNode = dummy;
        ListNode mpre = null;
        for (int i = 0; i < m; i++) {
            mpre = mNode;
            mNode = mNode.next;
        }

        ListNode nNode = mNode;
        ListNode npre = mpre;
        ListNode q2;

        for (int i = m; i <= n; i++) {
            q2 = nNode.next;
            nNode.next = npre;
            npre = nNode;
            nNode = q2;
        }


        mpre.next = npre;
        mNode.next = nNode;

        return dummy.next;
    }

    public static void main (String args[]){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;


        reverseBetween(a1, 2, 4);
    }
}
