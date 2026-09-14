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
    TreeNode cmnAncstr = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base case.
        if(root.val == p.val) return root;
        
        if(root.val == q.val) return root;

        if(root.val > p.val && root.val < q.val) return root;

        if(root.val > q.val && root.val < p.val) return root;
        //if  p and q < node, move to the left.
        if(p.val < root.val && q.val < root.val){
            cmnAncstr = lowestCommonAncestor(root.left, p, q);
        }
        //if p and q > node, move to the right.
        if(p.val > root.val && q.val > root.val){
           cmnAncstr = lowestCommonAncestor(root.right, p, q);
        }
        return cmnAncstr;
    }



}
