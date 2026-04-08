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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root != null) {
            // Add the first level to q if root is not null
            q.add(root);
        }
        while(!q.isEmpty()) {
            // Iterate till the queue is not empty
            List<Integer> levelValues = new ArrayList<>();
            
            // Add all the values in current level
            for(int i=0, len = q.size(); i<len; i++) { 
                // remove the head from queue and add to list;
                TreeNode node = q.poll();
                levelValues.add(node.val);

                // check if siblings are present and add left to right in queue
                if (node.left != null) {
                    q.add(node.left);
                } 
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(levelValues);
        }
        return result;
    }
}
