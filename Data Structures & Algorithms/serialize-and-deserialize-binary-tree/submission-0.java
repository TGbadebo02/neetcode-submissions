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

public class Codec {
    // Encodes a tree to a single string.
    private String tokens[];
    private int index;

    public String serialize(TreeNode root) {
        // 1. empty node, return empty string.
        // 2. Average case.

        if (root == null)
            return "";

        StringBuilder seralized = new StringBuilder();
        dfs(root, seralized);
        return seralized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        index = 0;
        tokens = data.split(",");
        return buildTree();
    }

    private void dfs(TreeNode node, StringBuilder str) {
        if (node == null) {
            str.append("null,");
            return;
        }

        str.append(node.val).append(",");

        dfs(node.left, str);
        dfs(node.right, str);
    }

    private TreeNode buildTree() {
        String token = tokens[index];
        index++;
        if (token.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }
}
