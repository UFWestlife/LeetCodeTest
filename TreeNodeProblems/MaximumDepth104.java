package TreeNodeProblems;
import java.util.*;
/**
 * Created by Administrator on 19-May-019.
 */
public class MaximumDepth104 {

    public static int maxDepth(TreeNode root) {// BFS, using Deque 双端队列
        if (root == null)
            return 0;

        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.push(root);
        int count = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);

                size--;
            }
            count++;

        }
        return count;
    }

    public static int maxDepth1(TreeNode root){ //BFS, using Queue
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode tmp = queue.poll();
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                size--;
            }
            count++;
        }
        return count;
    }

    public static int maxDepth2(TreeNode root){// DFS, using  Stack
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    public static void main(String args[]){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n6;
        n2.left = n3;
        n2.right = n4;
        n4.right = n5;

//        System.out.println(maxDepth(n1));
//        System.out.println(maxDepth1(n1));
        System.out.println(maxDepth2(n1));


//        Queue<Integer> q1 = new LinkedList<>();
//        q1.add(1);
//        q1.offer(2);
//        q1.offer(3);
//
//        System.out.println(q1);
//        q1.poll();
//        System.out.println(q1);
//        q1.remove();
//        System.out.println(q1);




    }
}
