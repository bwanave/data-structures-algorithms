package sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words, find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.
 * <p>
 * Example 1:
 * <p>
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 * Example 2:
 * <p>
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 */
class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        Map<String, Integer> wordsFrequency = new HashMap<>();
        for (String word : words)
            wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);

        int windowLen = words.length * words[0].length();

        for (int i = 0; i <= str.length() - windowLen; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int from = i + (j * words[0].length());
                int to = from + words[0].length();
                String word = str.substring(from, to);

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (!wordsFrequency.containsKey(word)) break;

                if (wordsSeen.get(word) > wordsFrequency.get(word)) break;

                if (j == words.length - 1) resultIndices.add(i);
            }
        }

        return resultIndices;
    }
}
