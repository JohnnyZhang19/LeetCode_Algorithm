public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) return true;
            if (i > 0 && sum % k == 0) return true;
        }
        return false; // if no subarray has sum = k, return false;
    
    }
}
