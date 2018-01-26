package LinkedListProblems;
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode dummyS = large;
        ListNode dummyL = small;

        ListNode cur = head;
        while(cur!= null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }
            if(cur.val >= x){
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }

        large.next = null;
        small.next = dummyL.next;
        return dummyS.next;
    }
}
