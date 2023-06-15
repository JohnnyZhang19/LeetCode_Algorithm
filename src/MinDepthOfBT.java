import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();

                if(current.left == null && current.right == null){
                    return depth;
                }

                if(current.left != null){
                    queue.offer(current.left);
                }

                if(current.right != null){
                    queue.offer(current.right);
                }
            }
        }
        return depth;
    }
}
