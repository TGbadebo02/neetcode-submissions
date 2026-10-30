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
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode node, TreeNode subNode){
        if(node == null){
            return false;
        }

        if(node != null && subNode == null){
            return false;
        }

        if(node.val == subNode.val){
            return dfsCompare(node,subNode);
        }

        return dfs(node.left, subNode) || dfs(node.right, subNode);

    }

    public boolean dfsCompare(TreeNode node, TreeNode subNode){
        if(node == null && subNode != null) return false;

        if(node != null && subNode == null) return false;

        if(node == null && subNode == null) return true;

        if(node.val != subNode.val){
            return false;
        }

        return dfsCompare(node.left, subNode.left) && dfsCompare(node.right,subNode.right);
    }
}
