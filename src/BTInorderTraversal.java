import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }
}
