/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode() {}
 *
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: there is no node to invert.
        if (root == null) {
            return null;
        }

        // Swap the left and right children of the current node.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert both subtrees.
        invertTree(root.left);
        invertTree(root.right);

        // The tree is modified in place, so return its root.
        return root;
    }
}
