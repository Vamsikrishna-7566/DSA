// Diameter of a Binary Tree
// Time: O(n). Auxiliary space: O(h) for recursion.

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        calHeight(root, result);
        return result[0];
    }

    public int calHeight(TreeNode root, int[] result) {
        if (root == null) return 0;

        int left = calHeight(root.left, result);
        int right = calHeight(root.right, result);

        result[0] = Math.max(result[0], left + right);
        return 1 + Math.max(left, right);
    }
}

// TreeNode is supplied by LeetCode. For local compilation, this
// package-private definition is included; omit it on LeetCode.
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
