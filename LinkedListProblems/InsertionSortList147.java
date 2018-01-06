package LinkedListProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSortList147 {
    public static ListNode insertionSortList(ListNode head) {
        if(head == null) return head;

        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }

        Arrays.sort(arr);
        ListNode cur = new ListNode(0);
        ListNode curr = cur;
        for (int i = 0; i < arr.length; i++){
            ListNode next = new ListNode(0);
            next.val = arr[i];
            cur.next = next;
            cur = cur.next;
        }
        return curr.next;
    }

    public static ListNode insertionSortList1(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void main(String args[]){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        System.out.print(insertionSortList1(node1));
    }
}
