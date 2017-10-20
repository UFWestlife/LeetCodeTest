package ListNodeProblems;

import java.util.ArrayList;

public class PalindromeLinkedList234 {
    public static   boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static boolean isPalindrome1(ListNode head) {
        ListNode tmp = head, prev = null;

        ArrayList<Integer> list = new ArrayList<>();
        while(tmp != null ){
            list.add(tmp.val);
            tmp = tmp.next;
        }

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        int i = 0;
        while(prev != null){
            if (prev.val != list.get(i)) return false;
            i++;
            prev = prev.next;
        }

        return true;
    }

    public static void main (String args[]){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

//        System.out.println(isPalindrome(node1));
        System.out.println(isPalindrome1(node1));

    }
}
