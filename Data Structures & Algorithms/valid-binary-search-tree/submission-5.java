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
        return helperValidator(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helperValidator(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        if (!(left < node.val && right > node.val))
            return false;
        return helperValidator(node.left, left, node.val) && helperValidator(node.right, node.val, right);
    }
}
