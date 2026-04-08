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
    // DFS solution
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxValue) {
        if (node == null)
            return 0;
        
        int result = node.val >= maxValue ? 1 : 0;
        maxValue = Math.max(maxValue, node.val);
        result += dfs(node.left, maxValue);
        result += dfs(node.right, maxValue);
        return result;
    }
}

