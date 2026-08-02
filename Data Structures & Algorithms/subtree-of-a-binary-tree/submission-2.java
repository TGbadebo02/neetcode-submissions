/**
 * Definition for a binary tree node.
 * public class TreeNode {
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
        // base case.
        if (root == null)
            return false;

        // edge case: compare root to subroot.
        if (dfs(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null)
            return true;
        if (node == null || subRoot == null)
            return false;
        if (node.val != subRoot.val)
            return false;

        return dfs(node.left, subRoot.left) && dfs(node.right, subRoot.right);
    }
}
