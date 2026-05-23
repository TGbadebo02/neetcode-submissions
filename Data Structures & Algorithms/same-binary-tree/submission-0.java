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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //set the base case(s).
        if(p != null && q == null) return false;
        if(q != null && p == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(q);
        queue.offer(p);

        while(!queue.isEmpty()){
            
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if(node1 == null && node2 == null){
                continue;
            }
            
            if(node1 == null || node2 == null){
                return false;
            }

            if(node1.val != node2.val){
                return false;
            }

             queue.offer(node1.left);
             queue.offer(node2.left);

             queue.offer(node1.right);
             queue.offer(node2.right);
        }

        return true;
    }
}
