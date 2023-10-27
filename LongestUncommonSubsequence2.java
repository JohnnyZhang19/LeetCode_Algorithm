public class LongestUncommonSubsequence2 {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    count++;
                }
            }
            if (count == 0) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
