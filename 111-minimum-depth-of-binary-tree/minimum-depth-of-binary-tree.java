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
    private int currentMin = Integer.MAX_VALUE;
    private void solve(TreeNode root, int nodes) {
        if (nodes > currentMin) return;
        if (root.left == null && root.right == null) {
            currentMin = nodes;
            return;
        }
        if (root.left != null) solve(root.left, nodes + 1);
        if (root.right != null) solve(root.right, nodes + 1);
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        solve(root, 1);
        return this.currentMin;
    }
}