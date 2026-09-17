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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;
        
        int left = 0;
        int right = 0;

        if(node.left != null){
            left = Math.max(node.left.val,0);
        }

        if(node.right != null){
            right = Math.max(node.right.val,0);
        }

        dfs(node.left);
        dfs(node.right);

        maxSum = Math.max(maxSum, node.val + left + right);

        return Math.max(node.val,Math.max(left,right));

    }
}
