import java.util.*;

public class BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null) traverse(root, result);
    
        return result;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
}
