public class SumofRootToLeafBN {
    /*
     * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val * 2 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
}
