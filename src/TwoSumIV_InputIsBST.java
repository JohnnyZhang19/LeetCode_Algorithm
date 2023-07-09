import java.util.ArrayList;
import java.util.List;
public class TwoSumIV_InputIsBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0, j = list.size() - 1; i < j;) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            } else if (list.get(i) + list.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
