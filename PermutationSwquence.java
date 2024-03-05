import java.util.ArrayList;
import java.util.List;
class PermutationSwquence {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return helper(nums, k - 1);
    }
    private String helper(List<Integer> nums, int k) {
        if (nums.size() == 1) {
            return nums.get(0).toString();
        }
        int n = nums.size();
        int index = k / factorial(n - 1);
        int num = nums.get(index);
        nums.remove(index);
        return num + helper(nums, k % factorial(n - 1));
    }
    private int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}