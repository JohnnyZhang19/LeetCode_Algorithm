public class BTTilt {
    private int totalTilt = 0;

    protected int value(TreeNode node) {
        return(node == null) ? 0 : node.val;
    }
    protected int tilt(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftTilt = tilt(node.left);
        int rightTilt = tilt(node.right);
        totalTilt += Math.abs(leftTilt - rightTilt);
        return value(node) + leftTilt + rightTilt;
    }
    
    public int findTilt(TreeNode root) {
        tilt(root);
        return totalTilt;
    }

    protected int sum(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;
        return node.val + leftSum + rightSum;
    
    }

}
