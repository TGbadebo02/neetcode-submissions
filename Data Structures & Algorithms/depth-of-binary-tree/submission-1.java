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
        //set the base case.
        if(root == null) return 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;

        while(!queue.isEmpty()){
            
            int size = queue.size();

            for(int i = 0; i < size; i++){
                
                TreeNode node = queue.poll();

                if(node.left != null && node.right != null){
                    level++;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }

                if(node.left != null && node.right == null){
                    level++;
                    queue.offer(node.left);
                }

                if(node.left == null && node.right != null){
                    level++;
                    queue.offer(node.right);
                }
            }
        }

        return level;
    }
}
