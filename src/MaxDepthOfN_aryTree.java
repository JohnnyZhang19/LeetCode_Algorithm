import java.util.Queue;
import java.util.LinkedList;

public class MaxDepthOfN_aryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            depth++;
        }
        return depth;
    }
}
