package BinaryTree;

import java.util.*;

public class BinaryTreeRightSideView199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            for(int i = 0;i < cnt;i++){
                TreeNode cur = q.poll();
                if(i == cnt-1){
                    ret.add(cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return ret;
    }

    public static List<Integer> rightSideView1(TreeNode root) {// recursive
        ArrayList list = new ArrayList();
        rightSideView(root, 0, list);

        return list;
    }

    public static void rightSideView(TreeNode root, int level, ArrayList list) {
        if(root == null) return;

        if(list.size() == level)
            list.add(root.val);

        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }

    public static void main(String args[]){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(rightSideView(node1));
        System.out.println(rightSideView1(node1));
    }
}
