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
    public boolean isValidBST(TreeNode root) {
        return helperValidateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helperValidateBST(TreeNode node, long left, long right) {
        if (node == null) 
            return true;
        if (!(left < node.val && right > node.val)) {
            return false;
        }
        return helperValidateBST(node.left, left, node.val) && 
            helperValidateBST(node.right, node.val, right);
    }
}
