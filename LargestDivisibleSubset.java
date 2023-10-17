import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0 || nums == null) return new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int currentTail = nums[index];
        int currentSize = max;
        for(int i = index; i >= 0; i--){
            if(currentSize == 0) break;
            if(currentSize == dp[i] && currentTail % nums[i] == 0){
                res.add(nums[i]);
                currentTail = nums[i];
                currentSize--;
            }
        }
        return res;
    }
    
}
