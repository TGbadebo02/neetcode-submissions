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
    public int maxPathSum(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxSum) {
        if (node == null)
            return 0;

        int total = node.val;

        if (node.left != null) {
            int left = node.left.val;
            total += left;
        }
        if (node.right != null) {
            int right = node.right.val;
            total += right;
        }

        maxSum = Math.max(total, maxSum); //15
        
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = dfs(node.left, maxSum); //dfs(10,15)
        }
        
        if (node.right != null) {
            right = dfs(node.right, maxSum); //dfs(20,15)
            //20 + 15 + 5 = 40 ... maxSum = 40
        }

        return Math.max(maxSum,Math.max(left,right));
    }
}
