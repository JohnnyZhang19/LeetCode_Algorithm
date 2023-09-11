import java.util.List;
import java.util.ArrayList;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {   
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum * 2 + nums[i];
            result.add(sum % 5 == 0);
            sum = sum % 5;
        }
        return result;
    }
}
