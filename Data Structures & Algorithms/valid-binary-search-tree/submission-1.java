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

    public boolean isValidBST(TreeNode root) {
        return dfs(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }

    public boolean dfs(int left, TreeNode node, int right) {
        // base case.
        if (node == null)
            return true;

        if(node.val <= left || node.val >= right){
            return false;
        }

        return dfs(left, node.left, node.val) && dfs(node.val, node.right, right);
    }
}
