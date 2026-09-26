/**
 * Subtree of Another Tree - recursive solution.
 * Assumes subRoot is non-null, as in the problem constraints.
 * Time: O(N * M) worst case. Auxiliary space: O(H) for root height H.
 * LeetCode supplies TreeNode; the definition below is commented out.
 * For local compilation, uncomment this definition.
 *
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return sameTree(root.left, subRoot.left)
                && sameTree(root.right, subRoot.right);
    }
}
