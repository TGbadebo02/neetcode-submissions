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
            left = dfs(node.left);
        }

        if(node.right != null){
            right = dfs(node.right);
        }
        
        int leftMax = Math.max(left,0);
        int rightMax = Math.max(right,0);

        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax,rightMax);

    }
}
