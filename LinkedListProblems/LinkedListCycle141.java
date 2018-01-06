package LinkedListProblems;

/**
 * Created by Administrator on 26-May-026.
 */
public class LinkedListCycle141 {
    public static boolean hasCycle(ListNode head) {//two pointer, one chases another
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
