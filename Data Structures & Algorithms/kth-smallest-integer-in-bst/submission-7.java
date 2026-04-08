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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> elements = new ArrayList<>();
        dfs(root, elements);
        Collections.sort(elements);
        return elements.get(k - 1);
    }

    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> e) {
        if(root == null) return e;

        dfs(root.left, e);
        e.add(root.val);
        dfs(root.right, e);

        return e;
    }
}