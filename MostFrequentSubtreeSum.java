import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + helper(root.left, map) + helper(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}