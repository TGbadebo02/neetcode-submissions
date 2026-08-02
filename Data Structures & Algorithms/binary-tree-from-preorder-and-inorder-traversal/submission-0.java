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
    HashMap<Integer, Integer> preordMap = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            //preorderMap.put(i, preorder[i]); x 
            preordMap.put(inorder[i],i);
        }

        // int rootval = preordMap.get(0);
        // TreeNode node = new TreeNode(rootval); <- redundant, not yet

        return dfs(preorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int left, int right){
        //base case.
        //if(null == null) x
        if(left > right) return null;

        //int rootval = preordMap.get(index++); x
        int rootval = preorder[index++];
        TreeNode node = new TreeNode(rootval);
        int mid = preordMap.get(rootval);
        node.left = dfs(preorder, left, mid - 1);
        node.right = dfs(preorder, mid + 1, right);
        return node;
    }
}
