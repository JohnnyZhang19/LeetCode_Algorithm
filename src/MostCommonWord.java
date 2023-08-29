import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Collections;
public class MostCommonWord {
    // Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
    // The words in paragraph are case-insensitive and the answer should be returned in lowercase.
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]+", " ").split(" ");

        for (String word : words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
        }

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
