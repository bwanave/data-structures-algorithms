package leetcode.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 * Example 4:
 * <p>
 * Input: String="cbbebi", K=10
 * Output: 6
 * Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */
class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {

        int longestSubstring = 0;
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < str.length()) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) map.remove(startChar);
                start += 1;
            }
            end += 1;
        }

        longestSubstring = Math.max(longestSubstring, end - start + 1);

        return longestSubstring;
    }
}
