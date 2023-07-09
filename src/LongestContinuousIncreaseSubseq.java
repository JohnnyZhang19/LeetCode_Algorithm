public class LongestContinuousIncreaseSubseq {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 0, count = 0;
        for(int i=0; i < nums.length; i++) {
            if(i == 0 || nums[i] > nums[i-1])
                count++;
            else
                count = 1;
            max = Math.max(max, count);
        }
        return max;
    
    }
}
