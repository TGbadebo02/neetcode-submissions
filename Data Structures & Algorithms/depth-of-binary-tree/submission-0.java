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
    public int maxDepth(TreeNode root) {
       
        int count = 0;
        int depth = dfs(root,count);
        return depth;
    }

    public int dfs(TreeNode node, int count){
        if(node == null){
            return 0;
        }

        count++;

        int left = 1 + dfs(node.left, count);
        int right = 1 + dfs(node.right, count);

        return Math.max(left,right);
    }
}
