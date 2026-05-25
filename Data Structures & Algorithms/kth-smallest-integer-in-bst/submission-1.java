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
    int kval = 0;
    int kcount = 0;
    
    public int kthSmallest(TreeNode root, int k) {
       dfs(root,k);
       return kval; 
    }

    public void dfs(TreeNode node, int k){
        //set the base case.
        if(node == null) return;
        
        dfs(node.left,k);
        
        kcount++;
        
        if(kcount == k){
            kval = node.val;
            return;
        }


        dfs(node.right,k);
    }
}
