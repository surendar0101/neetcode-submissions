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
    // BFS solution
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        int result = 0;
        q.offer(new Pair<>(root, Integer.MIN_VALUE));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            Integer maxVal = pair.getValue();
            if (node.val >= maxVal)
                result++;
            if (node.left != null)
                q.offer(new Pair<>(node.left, Math.max(node.val, maxVal)));
            if (node.right != null)
                q.offer(new Pair<>(node.right, Math.max(node.val, maxVal)));
        }
        return result;
    }
}
