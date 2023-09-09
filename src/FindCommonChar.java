import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FindCommonChar {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] temp = new int[26];
            for (char c : word.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }
}
