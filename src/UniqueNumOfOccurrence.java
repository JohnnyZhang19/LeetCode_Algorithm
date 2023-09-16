import java.util.Set;
import java.util.HashSet;
public class UniqueNumOfOccurrence {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i : arr) {
            count[i + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : count) {
            if (i != 0) {
                if (!set.add(i)) {
                    return false;
                }
            }
        }
        return true;
    
    }
}
