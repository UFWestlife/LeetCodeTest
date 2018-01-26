package TreeNodeProblems;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
the two subtrees of every node never differ by more than 1.

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class ConvertSortedArraytoBST108 {
    //Recursive
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode(0);
        return head = helper(nums, 0, nums.length-1);

    }

    private TreeNode helper(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, lo, mid-1);
        node.right = helper(nums, mid+1, hi);
        return node;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        /*************** Iterative Way using Queue ***************************/

        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        int val = nums[left + (right - left) / 2];
        TreeNode root = new TreeNode(val);
        queue.offer(new MyNode(root, left, right));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                MyNode cur = queue.poll();

                int mid = cur.lb + (cur.rb - cur.lb) / 2;

                if (mid != cur.lb) {
                    TreeNode leftChild = new TreeNode(nums[cur.lb + (mid - 1 - cur.lb) / 2]);
                    cur.node.left = leftChild;
                    queue.offer(new MyNode(leftChild, cur.lb, mid - 1));
                }

                if (mid != cur.rb) {
                    TreeNode rightChild = new TreeNode(nums[mid + 1 + (cur.rb - mid - 1) / 2]);
                    cur.node.right = rightChild;
                    queue.offer(new MyNode(rightChild, mid + 1, cur.rb));
                }
            }
        }

        return root;
    }

    private static class MyNode {
        TreeNode node;
        int lb;
        int index;
        int rb;

        public MyNode(TreeNode n, int theLeft, int theRight) {
            this.node = n;
            this.lb = theLeft;
            this.rb = theRight;
        }
    }
}
