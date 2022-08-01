package leetcode.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 * <p>
 * Input: String="aabdec", Pattern="abac"
 * Output: "aabdec"
 * Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
 * Example 3:
 * <p>
 * Input: String="abdbca", Pattern="abc"
 * Output: "bca"
 * Explanation: The smallest substring having all characters of the pattern is "bca".
 * Example 4:
 * <p>
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
class MinimumWindowSubstring {
    private final static int INFINITY = Integer.MAX_VALUE - 1;

    public static String findSubstring(String str, String pattern) {

        int minSubstringStart = 0;
        int minSubstringEnd = INFINITY;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int matched = 0;
        int start = 0, end = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) matched += 1;
            }

            while (matched == map.size()) {
                int currentWindowLength = end - start + 1;
                int prevMatchedSubstringLength = minSubstringEnd - minSubstringStart + 1;
                if (currentWindowLength < prevMatchedSubstringLength) {
                    minSubstringEnd = end;
                    minSubstringStart = start;
                }

                char startChar = str.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) matched -= 1;
                    map.put(startChar, map.get(startChar) + 1);
                }
                start += 1;
            }
            end += 1;
        }
        return minSubstringEnd == INFINITY ? "" : str.substring(minSubstringStart, minSubstringEnd + 1);
    }
}