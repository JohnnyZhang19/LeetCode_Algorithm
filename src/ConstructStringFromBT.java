public class ConstructStringFromBT {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = root.val + "";
        String left = tree2str(root.left);
        if (left.equals("") && root.right != null){
            left = "()";
        }else if(!left.equals("")){
            left = "(" + left + ")";
        }

        String right = tree2str(root.right);
        if (!right.equals("")) {
            right = "(" + right + ")";
        }
        return result+left+right;
    }
}
