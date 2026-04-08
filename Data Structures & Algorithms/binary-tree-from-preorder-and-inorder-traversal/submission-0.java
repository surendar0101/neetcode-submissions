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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 0th index of preorder will always be root
        TreeNode root = new TreeNode(preorder[0]);

        // Find the index of root in inorder to find the split of branch
        int mid = -1;
        for(int i=0; i< inorder.length; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }

        // Build left subTree recursively
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreOrder, leftInOrder);

        // Build right subTree recursively
        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
    }
}
