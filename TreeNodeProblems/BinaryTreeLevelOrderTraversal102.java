package TreeNodeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {// BFS using queue
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            res.add(currLevel);
        }
        return res;
    }

     public List<List<Integer>> levelOrder1(TreeNode root) { //DFS
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        levelOrderHelper(res, root, 0);
        return res;
    }

    public  void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null)
            return;
        List<Integer> curr;
        if (level >= res.size()) {
            curr = new ArrayList<>();
            curr.add(root.val);
            res.add(curr);
        } else {
            curr = res.get(level);
            curr.add(root.val);
            //res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
        }
        levelOrderHelper(res, root.left, level + 1);
        levelOrderHelper(res, root.right, level + 1);
    }
}
