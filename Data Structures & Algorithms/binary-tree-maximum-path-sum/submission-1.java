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
    private int maxPthSum;
    public int maxPathSum(TreeNode root) {
        maxPthSum = Integer.MIN_VALUE;
        dfs(root, Integer.MIN_VALUE);
        return maxPthSum;
    }

    public int dfs(TreeNode node, int maxSum) {
        if (node == null)
            return 0;

        int leftSum = 0;
        int rightSum = 0;

        //maxSum = Math.max(total, maxSum); //15
        
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = dfs(node.left, maxSum); //dfs(10,15)
        }
        
        if (node.right != null) {
            right = dfs(node.right, maxSum); //dfs(20,15)
            //20 + 15 + 5 = 40 ... maxSum = 40
        }
        
        int total = node.val + Math.max(0,left) + Math.max(0,right);
        maxPthSum = Math.max(maxPthSum,total);
        
        int lftSide = node.val + left;
        int rghtSide = node.val + right;

        return Math.max(node.val,Math.max(lftSide,rghtSide));
    }
}
