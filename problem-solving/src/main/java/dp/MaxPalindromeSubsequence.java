package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 516. Longest Palindromic Subsequence
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class MaxPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s, 0, s.length() - 1, new HashMap<>());
    }

    public int longestPalindromeSubseq(String str, int startIdx, int endIdx, Map<String, Integer> memo) {
        String key = startIdx + "," + endIdx;
        if (memo.containsKey(key))
            return memo.get(key);
        if (startIdx == endIdx)
            return 1;
        if (startIdx > endIdx)
            return 0;

        if (str.charAt(startIdx) == str.charAt(endIdx))
            memo.put(key, 2 + longestPalindromeSubseq(str, startIdx + 1, endIdx - 1, memo));
        else {
            int max = Math.max(longestPalindromeSubseq(str, startIdx + 1, endIdx, memo),
                    longestPalindromeSubseq(str, startIdx, endIdx - 1, memo));
            memo.put(key, max);
        }
        return memo.get(key);
    }
}
