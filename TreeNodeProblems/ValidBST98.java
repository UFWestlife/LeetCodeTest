package TreeNodeProblems;

import java.util.Stack;

public class ValidBST98 {
    static boolean bl = true;
    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        fuck(root);
        return bl;
    }

    public static void fuck(TreeNode root){
        if(root.left != null){
            if(root.left.val<root.val) fuck(root.left);
            else{
                bl = false;
                return;
            }
        }
        if(root.right != null){
            if(root.right.val>root.val) fuck(root.right);
            else{
                bl = false;
                return;
            }
        }
        return;
    }


    public static boolean isValidBST1 (TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode> ();// DFS iterative
        if (root == null) return true;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
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

        System.out.println(isValidBST(node1));
    }
}
