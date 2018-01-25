package TreeNodeProblems;

public class BalancedBinaryTree10 {
    private static boolean result = true;

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }

    public static void main(String args[]){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node1.left = node2; node1.right = node10;
        node2.left = node3; node2.right = node6;
        node3.left = node4; node3.right = node5;
                            node6.right = node7;
                            node7.right = node8;
        node8.left = node9;

        System.out.println(isBalanced(node1));
    }
}
