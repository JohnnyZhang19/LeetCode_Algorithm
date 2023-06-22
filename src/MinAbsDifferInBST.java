public class MinAbsDifferInBST {
    // Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
    Integer prev , min;

    public int getMinimumDifference(TreeNode root){
        prev = null;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;
        inorder(root.right);
    }





}
