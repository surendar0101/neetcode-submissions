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
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfsSerialize(root, result);
        return String.join(",", result);
    }

    private void dfsSerialize(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("N");
            return;
        }

        result.add(String.valueOf(root.val));
        dfsSerialize(root.left, result);
        dfsSerialize(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] i = {0};
        return dfsDeserialize(values, i);
    }

    private TreeNode dfsDeserialize(String[] values, int[] i) {
        if (values[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(values[i[0]]));
        i[0]++;
        node.left = dfsDeserialize(values, i);
        node.right = dfsDeserialize(values, i);
        return node;
    }
}
