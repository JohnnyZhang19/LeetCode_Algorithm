public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        // Step 1: Radix Sort
        int maxNum = nums[0];
        for (int num : nums) maxNum = Math.max(maxNum, num);
        
        int exp = 1; // Starts with the least significant digit
        int[] aux = new int[nums.length];
        
        while (maxNum / exp > 0) { // Go through every digit
            int[] count = new int[10];
            
            for (int num : nums) {
                count[(num / exp) % 10]++;
            }
            
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            
            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            }
            
            System.arraycopy(aux, 0, nums, 0, nums.length);
            exp *= 10;
        }
        
        // Step 2: Find the maximum gap
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
}
