import java.util.*;

//递归遍历
public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println("前序遍历");
        preorder(node1);
        System.out.println("---------------------");
        preorder3(node1);
        System.out.println("---------------------");
        System.out.println("中序遍历");
        midorder(node1);
        System.out.println("---------------------");
        midorder2(node1);
        System.out.println("---------------------");
        System.out.println("后序遍历");
        postorder(node1);
        System.out.println("---------------------");
        postorder2(node1);
        System.out.println("---------------------");
        System.out.println("层序遍历");
        ArrayList list = new ArrayList();
        levelOrder(node1,1, list);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("---------------------");
        levelOrder2(node1);
    }

    //前序遍历 根左右
    public static void preorder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val); //前序：第一次成为栈顶元素即打印
        preorder(root.left);
        preorder(root.right);
    }
    //前序遍历 迭代遍历
    public static void preorder3(TreeNode root){
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                if (root != null) {
                    System.out.println(root.val);
                    stack.push(root.right);
                    stack.push(root.left);
                }
            }
        }
    }

    //中序遍历 左根右
    public static void midorder(TreeNode root){
        if (root == null) return;
        midorder(root.left);
        System.out.println(root.val); //中序：第二次成为栈顶元素即打印
        midorder(root.right);
    }
    //中序遍历 迭代遍历
    public static void midorder2(TreeNode root){
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (root != null || !stack.isEmpty()){
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    //后序遍历 左右根
    public static void postorder(TreeNode root){
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val); //后序：第三次成为栈顶元素即打印
    }
    //后序遍历 迭代遍历
    public static void postorder2(TreeNode root){
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()){
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev){
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }

    //层序遍历：从上往下，从左往右
    public static void levelOrder(TreeNode root, int i, ArrayList list){
        if (root == null) return;
        int length = list.size();
        if (length <= i){
            for (int j = 0; j <= i-length; j ++){
                list.add(length + j, null);
            }
        }
        list.set(i,root.val);
        levelOrder(root.left, 2*i, list);
        levelOrder(root.right, 2*i+1, list);
    }
    //层序遍历 迭代遍历
    public static void levelOrder2(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                System.out.println(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
    }




}















