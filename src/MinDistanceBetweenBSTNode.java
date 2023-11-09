public class MinDistanceBetweenBSTNode {
    Integer prev, minDiff;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inOrder(root);
        return minDiff;
    }
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        inOrder(root.right);
    }
}
