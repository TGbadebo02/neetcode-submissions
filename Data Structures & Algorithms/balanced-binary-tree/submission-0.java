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
    public boolean isBalanced(TreeNode root) {
        //base case.
        if(root == null) return true;
        
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);

        if(Math.abs(left - right) > 1){
            return false;
        }

        return true;
    }


    public int dfsHeight(TreeNode node){
        if(node == null) return 0;

        int left = 1 + dfsHeight(node.left);
        int right = 1 + dfsHeight(node.right);

        return Math.max(left,right);
    }


}
