/**
 * Balanced Binary Tree using postorder DFS.
 * Time: O(n). Auxiliary space: O(h), worst case O(n).
 * LeetCode: submit Solution only; TreeNode is supplied there.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return calHeight(root) != -1;
    }

    public int calHeight(TreeNode root) {
        if (root == null) return 0;

        int left = calHeight(root.left);
        if (left == -1) return -1;

        int right = calHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}

// Included for standalone compilation. Omit on LeetCode.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
