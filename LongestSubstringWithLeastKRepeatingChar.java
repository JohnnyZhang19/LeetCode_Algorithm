public class LongestSubstringWithLeastKRepeatingChar {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                String[] subs = s.split(String.valueOf(s.charAt(i)));
                for (String sub : subs) {
                    max = Math.max(max, longestSubstring(sub, k));
                }
                return max;
            }
        }
        return s.length();
    }
}
