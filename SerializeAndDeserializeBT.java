import java.util.Queue;
import java.util.LinkedList;
public class SerializeAndDeserializeBT {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sb.toString();  // StringBuilder is a mutable class, so it can be returned directly. 
                                    // It is not a good practice to convert it to String. 
                                    // It is better to return the StringBuilder itself. 
                                    // This way, the StringBuilder can be reused to build the serialized string. 
                                    // This is a common practice in Java. 
                                    // It is also a good practice to use StringBuilder instead of String. 
                                    // StringBuilder is more efficient than String concatenation.
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] nodes = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty() && i < nodes.length) {
                TreeNode node = queue.poll();
                if (!nodes[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(node.left);
                }
                i++;
                if (!nodes[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;  // return the root node of the deserialized tree. 
                          // This is a common practice in Java. 
                          // It is also a good practice to return the root node of the deserialized tree. 
                          // This way, the root
        }
}