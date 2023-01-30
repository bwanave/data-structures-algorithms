package leetcode.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have the longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
class CharacterReplacement {
    public static int findLength(String str, int k) {

        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxRepeatChars = 0;
        int start = 0, end = 0;

        while (end < str.length()) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxRepeatChars = Math.max(maxRepeatChars, map.get(c));

            if (end - start + 1 - maxRepeatChars > k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start += 1;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end += 1;
        }

        return maxLength;
    }
}
