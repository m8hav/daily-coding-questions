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

    private int solveBFS(TreeNode root) {
        /**
            Relatively better than DFS
            stops as soon as it finds leaf node on any level

            somehow worse results than DFS in submission results though
         */
        
        if (root == null) return 0;

        class LevelTreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            int depth;
            public LevelTreeNode(TreeNode node, int depth) {
                this.val = node.val;
                this.left = node.left;
                this.right = node.right;
                this.depth = depth;
            }
        }

        Queue<LevelTreeNode> queue = new ArrayDeque<>();
        queue.add(new LevelTreeNode(root, 0));
        LevelTreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left == null && current.right == null)
                return current.depth + 1;
            if (current.left != null)
                queue.add(new LevelTreeNode(current.left, current.depth + 1));
            if (current.right != null)
                queue.add(new LevelTreeNode(current.right, current.depth + 1));
        }

        return 1;
    }

    private int solveDFS(TreeNode root) {
        /**
            Not optimal
            as left node might have 500 depth below and right only 1
            but it will still traverse full left subtree before checking right

            somehow better results than BFS in submission results though
         */
        if (root == null) return 0;
        int[] currentMin = new int[]{Integer.MAX_VALUE};
        _solveDFS(root, 1, currentMin);
        return currentMin[0];
    }
    private void _solveDFS(TreeNode root, int nodes, int[] currentMin) {
        if (nodes > currentMin[0]) return;
        if (root.left == null && root.right == null) {
            currentMin[0] = nodes;
            return;
        }
        if (root.left != null) _solveDFS(root.left, nodes + 1, currentMin);
        if (root.right != null) _solveDFS(root.right, nodes + 1, currentMin);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // return solveDFS(root);
        return solveBFS(root);
    }
}