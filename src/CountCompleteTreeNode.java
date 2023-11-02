public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);  // 1 + # of nodes in left subtree + # of nodes in right subtree.
    
    }
}
