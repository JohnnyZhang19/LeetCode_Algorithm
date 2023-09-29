import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, targetSum, result, path);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(path));
        }
        pathSum(root.left, targetSum - root.val, result, path);
        pathSum(root.right, targetSum - root.val, result, path);
        path.remove(path.size() - 1);
    }
}
