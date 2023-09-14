public class FindWordsFormedByChar {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for(char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int ans = 0;
        for(String word : words) {
            if(canForm(word, count)) {
                ans += word.length();
            }
        }
        return ans;
    }

    public boolean canForm(String word, int[] count) {
        int[] temp = new int[26];
        for(char c : word.toCharArray()) {
            temp[c - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(temp[i] > count[i]) {
                return false;
            }
        }
        return true;
    }
}
