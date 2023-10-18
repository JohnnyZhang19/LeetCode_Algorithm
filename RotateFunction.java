public class RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int f = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int max = f;
        for (int i = len - 1; i >= 0; i--) {
            f = f + sum - len * nums[i];
            max = Math.max(max, f);
        }
        return max;        
    }
}
