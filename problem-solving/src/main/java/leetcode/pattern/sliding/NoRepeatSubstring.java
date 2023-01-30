package leetcode.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring, which has all distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring with distinct characters is "abc".
 * Example 2:
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring with distinct characters is "ab".
 * Example 3:
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */
class NoRepeatSubstring {
    public static int findLength(String str) {

        int maxLength = 0;

        Map<Character, Integer> hashMap = new HashMap<>();
        int start = 0;
        for (int end = 0; end < str.length(); end++) {

            char c = str.charAt(end);

            if (hashMap.containsKey(c)) {
                start = Math.max(start, hashMap.get(c) + 1);
            }

            hashMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

