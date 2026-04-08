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
        if (root == null) 
            return true;
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[] {root, Long.MIN_VALUE, Long.MAX_VALUE});
        while(!q.isEmpty()) {
            Object[] current = q.poll();
            TreeNode node = (TreeNode) current[0];
            long left = (long) current[1], right = (long) current[2];
            if (!(left < node.val && right > node.val)) 
                return false;
            
            if (node.left != null) {
                q.offer(new Object[] {node.left, left, (long) node.val});
            }
            if (node.right != null) {
                q.offer(new Object[] {node.right, (long) node.val, right});
            }
        }
        return true;
    }
}
