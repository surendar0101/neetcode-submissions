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
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Pair<>(p, q));
        while (!queue.isEmpty()) {
            Pair<TreeNode, TreeNode> pair = queue.poll();
            TreeNode tree1 = pair.getKey();
            TreeNode tree2 = pair.getValue();
            if (tree1 == null && tree2 == null)
                continue;
            if (tree1 == null || tree2 == null || tree1.val != tree2.val) 
                return false;
            queue.offer(new Pair<>(tree1.left, tree2.left));
            queue.offer(new Pair<>(tree1.right, tree2.right));
        }
        return true;
    }
}
