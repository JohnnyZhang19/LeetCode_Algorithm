import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 1){
            result.add(nums[0] + "");
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i+1 < nums.length && (nums[i+1] - nums[i]) == 1){
                i++;
            }
            if(start != nums[i]){
                result.add(start + "->" + nums[i]);
            }else{
                result.add(nums[i] + "");
            }
        }
        return result;
    }
}
