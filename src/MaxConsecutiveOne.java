public class MaxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int num = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                num ++;
            }else if(nums[i] == 0){
                num = 0;
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
 