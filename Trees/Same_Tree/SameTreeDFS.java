/**
 * Same Tree: compare both structure and values.
 * For LeetCode, copy isSameTree into class Solution; use its TreeNode.
 * Worst-case time O(n). Extra space O(h) for the recursion stack.
 */
public class SameTreeDFS {
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
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
