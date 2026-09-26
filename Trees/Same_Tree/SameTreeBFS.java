import java.util.Queue;
import java.util.LinkedList;

/**
 * Same Tree: compare both structure and values.
 * For LeetCode, copy isSameTree into class Solution; use its TreeNode.
 * Worst-case time O(n). Extra space O(w) for the queue.
 */
public class SameTreeBFS {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();

            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null || temp2 == null) return false;
            if (temp1.val != temp2.val) return false;

            queue.offer(temp1.left);
            queue.offer(temp2.left);
            queue.offer(temp1.right);
            queue.offer(temp2.right);
        }
        return true;
    }
}
