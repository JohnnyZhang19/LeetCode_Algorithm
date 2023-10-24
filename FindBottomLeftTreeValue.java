public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        int[] res = new int[2];
        helper(root, 0, res);
        return res[1];
    }
    private void helper(TreeNode root, int level, int[] res) {
        if (root == null) return;
        helper(root.left, level + 1, res);
        if (level > res[0]) {
            res[1] = root.val;
            res[0] = level;
        }
        helper(root.right, level + 1, res);
    } 
}
