import java.util.LinkedList;
import java.util.Queue;

public class TreeDeep {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,node7,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,node6,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(minDepth(node1));
        System.out.println(minDepth1(node1));
    }

    //二叉树的最小深度
    //深度优先
    //时间复杂度 O(N)
    //空间复杂度 O(logN)
    public static int minDepth(TreeNode root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null){
            min = Math.min(minDepth(root.left),min);
        }
        if (root.right != null){
            min = Math.min(minDepth(root.right),min);
        }
        return min+1;
    }

    //广度优先
    //时间复杂度 O(N)
    //空间复杂度 O(N)
    public static int minDepth1(TreeNode root){
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null)
                return node.deep;
            if (node.left != null){
                node.left.deep = node.deep+1;
                queue.offer(node.left);
            }
            if (node.right != null){
                node.right.deep = node.deep+1;
                queue.offer(node.right);
            }
        }
        return 0;
    }


        static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int deep;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
