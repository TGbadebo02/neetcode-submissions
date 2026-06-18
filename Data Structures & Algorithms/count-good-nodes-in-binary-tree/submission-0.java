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
    public int goodNodes(TreeNode root) {
       if(root == null) return 0;

       int gdNode = 0;
       Queue<TreeNode> queue = new ArrayDeque<>();
       Queue<Integer> maxqueue = new ArrayDeque<>();

       queue.add(root);
       maxqueue.add(root.val);

       while(!queue.isEmpty()){
            
            TreeNode node = queue.poll();
            int maxCurrent = maxqueue.poll();
            
            if(node.val >= maxCurrent){
                gdNode++;
            }

            int newMax = Math.max(maxCurrent,node.val);

            if(node.left != null){
               queue.offer(node.left);
               maxqueue.offer(newMax);
            }
            if(node.right != null){
                queue.offer(node.right);
                maxqueue.offer(newMax);
            }
       }

       return gdNode;
    }
}
