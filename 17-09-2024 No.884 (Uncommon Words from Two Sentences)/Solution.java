import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Create a frequency map for all words
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        // Count occurrences of words in both sentences
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Find words that occur exactly once
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }
        
        // Convert the result to an array and return
        return result.toArray(new String[0]);
    }
}
